package model;

import java.io.Serializable;

public class Estoque implements Serializable {
    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private String movimentacao;

    public Estoque(Integer id, Produto produto, Integer quantidade, String movimentacao) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.movimentacao = movimentacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }
}
