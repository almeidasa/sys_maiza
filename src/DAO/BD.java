package DAO;

import Telas.TelaCadastro;
import Telas.TelaGerenciarUsr;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @Autor Alexandre
 * @Data 10/08/2018
 */
public class BD {

    private static String url = "jdbc:sqlite:lib/TarefasRedmine.db";
    private static Connection conn = null;

    //construtor padrão
    public BD() {

    }

    //construtor para trazer a combobox da tela para ser preenchida pelos dados vindos do banco
    private JComboBox bxAtividade;

    public BD(JComboBox bxAtividade) {
        this.bxAtividade = bxAtividade;
    }

    //construtor para o gerencia de Usr
    private JFormattedTextField txtCPF;
    private JTextField txtApiKey;
    private JTextField txtIdRedmine;
    private JTextField txtNome;
    private JLabel txtAviso;

    public BD(JFormattedTextField txtCPF, JTextField txtApiKey, JTextField txtIdRedmine, JTextField txtNome, JLabel txtAviso) {
        this.txtCPF = txtCPF;
        this.txtApiKey = txtApiKey;
        this.txtIdRedmine = txtIdRedmine;
        this.txtNome = txtNome;
        this.txtAviso = txtAviso;
    }

    //conexão ao banco
    private static Connection connect() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Erro connect: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public void deleteActivities() {
        String sql = "DELETE FROM atividades";
        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o atividades: " + e.getMessage());
        }
    }

    public void insertActivities(int id, String nome) {
        String sql = "INSERT INTO atividades (id, name) VALUES (?,?);";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nome);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //retorna todos as atividades e preenche direto na combobox
    public void preencherCombobox() {
        String sql = "SELECT name FROM atividades ORDER BY name ASC";

        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                bxAtividade.addItem(rs.getString("name"));
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro selectName: " + e);
            e.printStackTrace();
        }
    }

    //retorna todos os dados
    public void configuraDados() {
        String sql = "SELECT cpf, apiKey, idRedmine, nome FROM usuarios";
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Dados.cpf = rs.getString("cpf");
                Dados.apiAccessKey = rs.getString("apiKey");
                Dados.user_id = Integer.toString(rs.getInt("idRedmine"));
                Dados.nome = rs.getString("nome");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao carregar o usuário! " + e.getMessage());
            e.printStackTrace();
        }
    }

    //preenche a tela de gerencia Usr
    public void preencherTelaGerencia() {
        String sql = "SELECT cpf, apiKey, idRedmine, nome FROM usuarios";

        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                txtCPF.setText(rs.getString("cpf"));
                txtApiKey.setText(rs.getString("apiKey"));
                txtIdRedmine.setText(Integer.toString(rs.getInt("idRedmine")));
                txtNome.setText(rs.getString("nome"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao carregar o usuário! " + e.getMessage());
            e.printStackTrace();
        }
    }

    //alterar usuário
    public void updateUser() {
        String sql = "UPDATE usuarios SET "
                + "cpf='" + txtCPF.getText().replaceAll("[\\- | ^.]", "") + "',"
                + "apiKey='" + txtApiKey.getText() + "',"
                + "idRedmine=" + Integer.parseInt(txtIdRedmine.getText())
                + " WHERE cpf='" + TelaGerenciarUsr.cpfAntigo + "'";

        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            txtAviso.setText("Alterado com êxito!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao alterar o usuário: " + e.getMessage());
        }
    }

    public void deletarUser() {
        String cpf = txtCPF.getText();

        String sql = "DELETE FROM usuarios WHERE cpf='"
                + txtCPF.getText().replaceAll("[\\- | ^.]", "") + "'";

        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            txtAviso.setText("Usuário " + cpf + " excluído com êxito!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao deletar o usuário: " + e.getMessage());
        }
    }

    public void deletarLancamentos() {
        String sql = "DELETE FROM lancamentos";

        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao deletar o lançamentos: " + e.getMessage());
        }
    }

    public void deletarSequencia() {
        String sql = "DELETE FROM sqlite_sequence";

        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao deletar a sequencia de lançamentos: " + e.getMessage());
        }
    }

    //inserir usuario
    public void insertUser() {
        String sql = "INSERT INTO usuarios (cpf, apiKey, idRedmine, nome) VALUES (?,?,?,?)";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtCPF.getText().replaceAll("[\\- | ^.]", ""));
            pstmt.setString(2, txtApiKey.getText());
            pstmt.setInt(3, Integer.parseInt(txtIdRedmine.getText()));
            pstmt.setString(4, txtNome.getText());

            pstmt.executeUpdate();

            txtAviso.setText("Usuário criado com êxito!");

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao criar o usuário: " + e.getMessage());
        }
    }

    //retorna o id da atividade mediante o nome da atividade selecionado no combobox
    public void buscarIdPorNome(String nome_atividade) {
        String sql = "SELECT id FROM atividades WHERE name='" + nome_atividade + "'";
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TelaCadastro.id_atividade = rs.getInt("id");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro selectId " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String buscarCPF() {
        String sql = "SELECT cpf FROM usuarios";
        String cpf = "0";
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cpf = rs.getString("cpf");
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro: " + e;
        }
        return cpf;
    }

    //inserir atividades
    public void insertTarefas(String name, int id) {
        String sql = "INSERT INTO atividades(name,id) VALUES(?,?)";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro insertTarefas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //inserir lançamentos de horas
    public void inserirLancamentos(String hrInicio, String hrFim, String tempoGasto, String tarefa, String atividade, String comentario, String dataCadastro) {
        String sql = "INSERT INTO lancamentos (hora_inicio, hora_fim, tempo_gasto, tarefa, atividade, comentario, data_cadastro) VALUES (?,?,?,?,?,?,?)";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hrInicio);
            pstmt.setString(2, hrFim);
            pstmt.setString(3, tempoGasto);
            pstmt.setString(4, tarefa);
            pstmt.setString(5, atividade);
            pstmt.setString(6, comentario);
            pstmt.setString(7, dataCadastro);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            txtAviso.setText("Erro ao criar o usuário: " + e.getMessage());
        }
    }

    //retorna os lançamentos do dia
    public void buscarLancamentos(String dataCadastro, JTable TabLancamentos) {
        String sql = "SELECT * FROM lancamentos WHERE data_cadastro='" + dataCadastro + "'";
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel tabela = (DefaultTableModel) TabLancamentos.getModel();
            TabLancamentos.setFont(new Font("Arial", Font.PLAIN, 12));

            while (rs.next()) {

                tabela.addRow(new String[]{
                    Integer.toString(rs.getInt("id")),
                    "<html><p style=\"color:red\"><b>Não</b></><html>",
                    rs.getString("hora_inicio"),
                    rs.getString("hora_fim"),
                    rs.getString("tempo_gasto"),
                    rs.getString("tarefa"),
                    rs.getString("atividade"),
                    rs.getString("comentario")
                });
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            e.printStackTrace();
        }
    }

    public void apagarLancamento(String id) {
        String sql = "DELETE FROM lancamentos WHERE id = " + id;
        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Apagar Lançamento!:\n" + ex, "Atenção", 0);
        }
    }

    //alterar lançamento
    public void alterarLancamento(int ID, String hrInicio, String hrFim, String tempoGasto, String tarefa, String atividade, String comentario) {
        String sql = "UPDATE lancamentos SET "
                + "hora_inicio='" + hrInicio + "', "
                + "hora_fim='" + hrFim + "', "
                + "tempo_gasto='" + tempoGasto + "', "
                + "tarefa='" + tarefa + "', "
                + "atividade='" + atividade + "', "
                + "comentario='" + comentario + "' "
                + " WHERE id=" + ID;
        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o usuário: " + e.getMessage(), "Atenção", 0);
        }
    }
}
