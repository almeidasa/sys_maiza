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

    public Ficha(int id, String data, String nome_aluno, String nome_responsavel, double valor) {
        this.id = id;
        this.data = data;
        this.nome_aluno = nome_aluno;
        this.nome_responsavel = nome_responsavel;
        this.valor = valor;
    }

    public Ficha(String data, String nome_aluno, String nome_responsavel, double valor) {
        this.data = data;
        this.nome_aluno = nome_aluno;
        this.nome_responsavel = nome_responsavel;
        this.valor = valor;
    }

    public Ficha() {
    }

    public int getId() {
        return id;
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
