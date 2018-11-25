package Principal;

import Telas.TelaCadastro;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * @Autor Alexandre
 * @Data 07/08/2018
 */
public class Ahgora {
    //formato da data DDMMYYYY

    public static String Requisicao(String data, String cpf) throws JSONException {
        String matricula = "<matricula>" + cpf + "</matricula>";
        String datai = "<datai>" + data + "</datai>";
        String dataf = "<dataf>" + data + "</dataf>";
        String iHeader = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://www.ahgora.com.br/ws\"><soapenv:Header/><soapenv:Body><ws:obterResultados><empresa>28efb2a0a70321a5de82c13c8f1042b0</empresa>";
        String fHeader = "<opcoes><Opcao><nome>periodo_aberto</nome><valor>true</valor></Opcao><Opcao><nome>apuracao_diaria</nome><valor>true</valor></Opcao></opcoes></ws:obterResultados></soapenv:Body></soapenv:Envelope>";
        String xml = iHeader + matricula + datai + dataf + fHeader;

        try {
            StringEntity stringEntity = new StringEntity(xml, "UTF-8");
            stringEntity.setChunked(true);
            HttpPost httpPost = new HttpPost("http://www.ahgora.com.br/ws/pontoweb.php");
            httpPost.setEntity(stringEntity);
            httpPost.addHeader("Accept", "text/xml");
            httpPost.addHeader("SOAPAction", "http://www.ahgora.com.br/ws/pontoweb.php/obterBatidas");

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response;
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            String strResponse = null;
            if (entity != null) {
                strResponse = EntityUtils.toString(entity);
            }

            JSONObject respJson = XML.toJSONObject(strResponse);
            JSONArray resultado = respJson.getJSONObject("SOAP-ENV:Envelope")
                    .getJSONObject("SOAP-ENV:Body")
                    .getJSONObject("ns1:obterResultadosResponse")
                    .getJSONObject("Resultados")
                    .getJSONArray("Resultado");
            JSONObject valor = resultado.getJSONObject(0);

            String horasTrabalhadas;
            if (valor.getString("nome").equals("Horas Trabalhadas")) {
                horasTrabalhadas = valor.getString("valor");
            } else {
                horasTrabalhadas = "00:00";
            }

            TelaCadastro.offline = false;
            return horasTrabalhadas;
        } catch (IOException | UnsupportedCharsetException | ParseException ex) {
            System.out.println("ERRO Ahgora: " + ex);
            TelaCadastro.offline = true;
            return "Offline";
        }
    }
}
