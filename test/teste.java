
import Telas.TelaCadastro;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.json.XML;

/**
 * @Autor Alexandre
 * @Data 21/08/2018
 */
public class teste {
//, JFormattedTextField txtCPF, JTextField txtNome, JTextField txtIdRedmine
    public static void main(String[] args) {
        buscarUsuario("d9991ea89ca81352c9dce1182bc47a1f319065fa");
    }

    public static void buscarUsuario(String apiKey) {
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

            System.out.println(user);
            System.out.println("nome " + user.getString("firstname"));
            System.out.println("cpf "+ user.getJSONObject("custom_fields").getJSONArray("custom_field").getJSONObject(2).get("value"));

            System.out.println("id " + user.getInt("id"));
            
            TelaCadastro.offline = false;
        } catch (Exception ex) {
            System.out.println("ERRO Requisição redmine: " + ex);
            TelaCadastro.offline = true;
        }
    }
}
