package br.com.teskaro.listamidias.model;

public class Midia {
    private int id;
    private String nome;
    private String descricao;

    public Midia(){}

    public Midia(int id, String nome, String descricao){
        this.id        = id;
        this.nome      = nome;
        this.descricao = descricao;
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
}
