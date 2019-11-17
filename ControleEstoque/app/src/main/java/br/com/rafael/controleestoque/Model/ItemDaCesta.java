package br.com.rafael.controleestoque.Model;

import java.util.Date;

public class ItemDaCesta {

    private int codigo;
    private String nome;
    private long codigoAlimento;
    private String Validade;

    public ItemDaCesta(){

    }

    public long getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(long codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
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
                ", codigoAlimento=" + codigoAlimento +
                ", Validade='" + Validade + '\'' +
                '}';
    }
}
