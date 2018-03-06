package br.sabadini.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by gumgait on 05/03/18.
 */
public class Categoria {

    private String id;
    private String nome;
    private String descricao;
    private Boolean perecivel;
    private String caminhoImagem;

    public Categoria(String nome, String descricao, Boolean perecivel){
        this.id = GeradorID.gerar();
        this.nome = nome;
        this.descricao = descricao;
        this.perecivel = perecivel;
    }


    public Categoria() {

    }

    public Categoria(String nome) {
        this.id = GeradorID.gerar();
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Boolean getPerecivel() {
        return perecivel;
    }

    public void setPerecivel(Boolean perecivel) {
        this.perecivel = perecivel;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {
        private String nome;
        private String descricao;
        private Boolean perecivel;

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder perecivel(Boolean perecivel){
            this.perecivel = perecivel;
            return this;
        }
        public Builder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Categoria builder() {
            return new Categoria(nome, descricao, perecivel);
        }

    }
}
