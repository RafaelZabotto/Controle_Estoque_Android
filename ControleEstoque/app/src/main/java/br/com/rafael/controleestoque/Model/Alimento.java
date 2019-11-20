package br.com.rafael.controleestoque.Model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alimento {

    private int codigo;
    private String nome;
    private String nome_aux;
    private String validade;
    private String data_inseriu;
    private int qtdEstoque;

    public Alimento(){

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

    public String getNome_aux() {
        return nome_aux;
    }

    public void setNome_aux(String nome_aux) {
        this.nome_aux = nome_aux;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getData_inseriu() {
        return data_inseriu;
    }

    public void setData_inseriu(String data_inseriu) {
        this.data_inseriu = data_inseriu;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        /*return "Alimento{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", validade=" + validade +
                ", qtdEstoque=" + qtdEstoque +
                '}';*/

        while(this.nome.length() < 24){

            this.nome = this.nome + "\t";

        }

        return this.codigo + "      " + this.nome  + this.validade;
    }


}
