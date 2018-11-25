/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Telas.TelaCadastro;
import DAO.BD;
import Telas.TelaGerenciarUsr;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Alexandre
 */
public class CadastroRedmine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BD app = new BD();
            String cpf = app.buscarCPF();

            if (cpf.equals("0")) {
                new TelaGerenciarUsr().setVisible(true);
            } else {
                new BD().configuraDados();
                verificaConexao();
                new TelaCadastro().setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println("Erro: main " + ex);
        }

    }

    public static void verificaConexao() {
        try {
            URL url = new URL("https://www.google.com.br");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            TelaCadastro.offline = false;
            new BD().deleteActivities();
            new Redmine().BuscarAtividades();
        } catch (Exception ex) {
            TelaCadastro.offline = true;
            System.out.println("Erro: verificaConexao() " + ex);
        }
    }
}
