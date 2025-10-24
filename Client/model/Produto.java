package model;

import java.io.Serializable;

public class Produto implements Serializable {
    private Integer id;
    private String nome;
    private Double preco;
    private Fornecedor fornecedor;

    public Produto(Integer id, String nome, Double preco, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
