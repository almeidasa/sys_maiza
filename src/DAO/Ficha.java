package DAO;

/**
 * @Autor Alexandre
 * @Data 11/08/2018
 */
public class Ficha {
    private int id;
    private String data;
    private String nome_aluno;
    private String nome_responsavel;
    private double valor;
    private String nome_usuario;

    public Ficha(int id, String data, String nome_aluno, String nome_responsavel, double valor, String nome_usuario) {
        this.id = id;
        this.data = data;
        this.nome_aluno = nome_aluno;
        this.nome_responsavel = nome_responsavel;
        this.valor = valor;
        this.nome_usuario = nome_usuario;
    }

    public Ficha(String data, String nome_aluno, String nome_responsavel, double valor, String nome_usuario) {
        this.data = data;
        this.nome_aluno = nome_aluno;
        this.nome_responsavel = nome_responsavel;
        this.valor = valor;
        this.nome_usuario = nome_usuario;
    }

    public Ficha() {
    }

    public int getId() {
        return id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
