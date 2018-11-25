package DAO;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @Autor Alexandre
 * @Data 10/08/2018
 */
public class BD {

    private static String url = "jdbc:sqlite:lib/SysMaiza.db";
    private static Connection conn = null;

    //construtor padrão
    public BD() {

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

    public void deletarFicha(int id) {
        String sql = "DELETE FROM fichas WHERE id = " + id;

        try {
            connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar a ficha: " + e.getMessage());
        }
    }

    //inserir lançamentos de horas
    public void inserirFicha(Ficha ficha) {
        String sql = "INSERT INTO fichas (data, nome_aluno, nome_responsavel, valor) VALUES (?,?,?,?)";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ficha.getData());
            pstmt.setString(2, ficha.getNome_aluno());
            pstmt.setString(3, ficha.getNome_responsavel());
            pstmt.setDouble(4, ficha.getValor());

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar o ficha: " + e.getMessage());
        }
    }

    //retorna os lançamentos do dia
    public double buscarTotal() {
        String sql = "SELECT SUM(valor) FROM fichas;";
        double v = 0;
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                v = rs.getDouble("SUM(valor)");
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            e.printStackTrace();
        }
        return v;
    }
    
    
    //retorna os lançamentos do dia
    public void buscarFichas(JTable TabLancamentos) {
        String sql = "SELECT * FROM fichas";
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel tabela = (DefaultTableModel) TabLancamentos.getModel();
            TabLancamentos.setAutoCreateRowSorter(false);
            tabela.setNumRows(0);
            TabLancamentos.setFont(new Font("Arial", Font.PLAIN, 12));

            while (rs.next()) {
                System.out.println("Buscou");
                tabela.addRow(new String[]{
                    Integer.toString(rs.getInt("id")),
                    rs.getString("data"),
                    rs.getString("nome_aluno"),
                    rs.getString("nome_responsavel"),
                    Double.toString(rs.getDouble("valor"))
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

    //alterar lançamento
    public void alterarFicha(Ficha ficha) {
        String sql = "UPDATE fichas SET data = ?, nome_aluno = ?, nome_responsavel = ?, valor = ? WHERE id = ?";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ficha.getData());
            pstmt.setString(2, ficha.getNome_aluno());
            pstmt.setString(3, ficha.getNome_responsavel());
            pstmt.setDouble(4, ficha.getValor());
            pstmt.setInt(5, ficha.getId());
            System.out.println("Editando " +ficha.getId());
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o usuário: " + e.getMessage(), "Atenção", 0);
        }
    }
}
