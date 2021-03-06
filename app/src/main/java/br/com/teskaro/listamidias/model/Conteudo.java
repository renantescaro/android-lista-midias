package br.com.teskaro.listamidias.model;

public class Conteudo {
    private int id;
    private String nome;
    private String descricao;
    private int nota;
    private int idMidia;

    public Conteudo(){}

    public Conteudo(int id, String nome, String descricao, int nota,int idMidia){
        this.id        = id;
        this.nome      = nome;
        this.descricao = descricao;
        this.nota      = nota;
        this.idMidia   = idMidia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdMidia() { return idMidia; }

    public void setIdMidia(int idMidia) { this.idMidia = idMidia; }
}
