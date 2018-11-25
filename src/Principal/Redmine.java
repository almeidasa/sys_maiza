package Principal;

import DAO.BD;
import DAO.Dados;
import Telas.TelaCadastro;
import Uteis.DecimalParaHora;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.TimeEntryManager;
import com.taskadapter.redmineapi.bean.TimeEntry;
import com.taskadapter.redmineapi.bean.TimeEntryActivity;
import com.taskadapter.redmineapi.bean.TimeEntryFactory;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * @Autor Alexandre
 * @Data 07/08/2018
 */
public class Redmine {

    private static RedmineManager redmineManager;
    private static TimeEntryManager timeEntryManager;
    private static String url = "https://redmine.supera.com.br";

    public static String Requisicao(String data, JTable TabLancamentos, String apiAccessKey, String user_id) throws JSONException, InterruptedException {
        try {
            URL url = new URL("https://redmine.supera.com.br/time_entries.xml?key=" + apiAccessKey + "&user_id=" + user_id + "&spent_on=" + data + "&limit=100");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), HTTP.UTF_8));

            String strResponse = "";
            String output;
            while ((output = br.readLine()) != null) {
                strResponse += output;
            }
            br.close();
            conn.disconnect();

            JSONObject respJson = XML.toJSONObject(strResponse);
            JSONObject time_entries = respJson.getJSONObject("time_entries");

            if (time_entries.getInt("total_count") == 0) {
                DefaultTableModel tabela = (DefaultTableModel) TabLancamentos.getModel();
                tabela.setNumRows(0);
                return "0";
            } else if (time_entries.getInt("total_count") == 1) {
                JSONObject entries = time_entries.getJSONObject("time_entry");

                double horas = 00.00;
                horas = entries.getDouble("hours");
                String totalHoras = DecimalParaHora.Converter("" + horas);

                DefaultTableModel tabela = (DefaultTableModel) TabLancamentos.getModel();
                tabela.setNumRows(0);
                JSONObject issue;
                JSONObject activity;

                issue = entries.getJSONObject("issue");
                activity = entries.getJSONObject("activity");

                tabela.addRow(new String[]{
                    "--",
                    "<html><p style=\"color:green\"><b>Sim</b></><html>",
                    "----",
                    "----",
                    totalHoras,
                    Integer.toString(issue.getInt("id")),
                    activity.getString("name"),
                    entries.getString("comments")
                });

                return totalHoras;
            } else {
                JSONArray entries = time_entries.getJSONArray("time_entry");

                DefaultTableModel tabela = (DefaultTableModel) TabLancamentos.getModel();
                tabela.setNumRows(0);

                JSONObject issue;
                JSONObject activity;

                double horas = 00.00;
                for (int i = 0; i < entries.length(); i++) {
                    horas += entries.getJSONObject(i).getDouble("hours");
                    issue = entries.getJSONObject(i).getJSONObject("issue");
                    activity = entries.getJSONObject(i).getJSONObject("activity");

                    tabela.addRow(new String[]{
                        "--",
                        "<html><p style=\"color:green\"><b>Sim</b></><html>",
                        "----",
                        "----",
                        DecimalParaHora.Converter(Double.toString(entries.getJSONObject(i).getDouble("hours"))),
                        Integer.toString(issue.getInt("id")),
                        activity.getString("name"),
                        entries.getJSONObject(i).getString("comments")
                    });
                }
                String totalHoras = DecimalParaHora.Converter(String.format("%,.2f", horas));

                TelaCadastro.offline = false;
                return totalHoras;
            }
        } catch (Exception ex) {
            System.out.println("ERRO Requisição redmine: " + ex);
            TelaCadastro.offline = true;
            return "Offline";
        }
    }

    public void BuscarAtividades() {
        RedmineManager mgr = RedmineManagerFactory.createWithApiKey(url, Dados.apiAccessKey);
        TimeEntryManager issueManager = mgr.getTimeEntryManager();

        List<TimeEntryActivity> activities;
        try {
            activities = issueManager.getTimeEntryActivities();
            activities.forEach((activitie) -> {
                new BD().insertActivities(activitie.getId(), activitie.getName());
            });
        } catch (RedmineException ex) {
            System.out.println("Erro buscar atividades: " + ex);
        }
    }

    //Creating objects from Redmine
    public static void Incluir(int issue, Date date, float hours, int activities, String comments) {
        redmineManager = RedmineManagerFactory.createWithApiKey(url, Dados.apiAccessKey);
        timeEntryManager = redmineManager.getTimeEntryManager();

        TimeEntry te = TimeEntryFactory.create();
        te.setIssueId(issue);
        te.setSpentOn(date);
        te.setHours(hours);
        te.setActivityId(activities);
        te.setComment(comments);

        try {
            timeEntryManager.createTimeEntry(te);
        } catch (RedmineException e) {
            JOptionPane.showMessageDialog(null, "Erro incluir Redmine " + e);
        }
    }

    public static void buscarUsuario(String apiKey, JFormattedTextField txtCPF, JTextField txtNome, JTextField txtIdRedmine) {
        try {
            URL url = new URL("https://redmine.supera.com.br/users/current.xml?key=" + apiKey);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), HTTP.UTF_8));

            String strResponse = "";
            String output;
            while ((output = br.readLine()) != null) {
                strResponse += output;
            }
            br.close();
            conn.disconnect();

            JSONObject respJson = XML.toJSONObject(strResponse);
            JSONObject user = respJson.getJSONObject("user");

            txtIdRedmine.setText(Integer.toString(user.getInt("id")));
            txtNome.setText(user.getString("firstname") + " " + user.getString("lastname"));
            txtCPF.setText(user.getJSONObject("custom_fields").getJSONArray("custom_field").getJSONObject(2).getString("value"));
            TelaCadastro.offline = false;
        } catch (Exception ex) {
            System.out.println("ERRO Requisição redmine: " + ex);
            TelaCadastro.offline = true;
        }
    }
}
