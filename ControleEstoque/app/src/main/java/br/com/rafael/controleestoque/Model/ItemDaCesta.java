package br.com.rafael.controleestoque.Model;

import java.util.Date;

public class ItemDaCesta {

    private int codigo;
    private String nome;
    private int quantidadeSelecionada;
    private String Validade;

    public ItemDaCesta(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeSelecionada() {
        return quantidadeSelecionada;
    }

    public void setQuantidadeSelecionada(int quantidadeSelecionada) {
        this.quantidadeSelecionada = quantidadeSelecionada;
    }

    public String getValidade() {
        return Validade;
    }

    public void setValidade(String validade) {
        Validade = validade;
    }

    @Override
    public String toString() {
        return "ItemDaCesta{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", quantidadeSelecionada=" + quantidadeSelecionada +
                ", Validade=" + Validade +
                '}';
    }
}
