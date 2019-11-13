package br.com.rafael.controleestoque.Model;

import java.util.Date;
import java.util.List;

public class Cesta {

    private int codigo;
    private Alimento alimentoDoado;
    private Date dataCesta;
    private List<ItemDaCesta> itensCesta;

    public Cesta() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Alimento getAlimentoDoado() {
        return alimentoDoado;
    }

    public void setAlimentoDoado(Alimento alimentoDoado) {
        this.alimentoDoado = alimentoDoado;
    }

    public Date getDataCesta() {
        return dataCesta;
    }

    public void setDataCesta(Date dataCesta) {
        this.dataCesta = dataCesta;
    }

    public List<ItemDaCesta> getItensCesta() {
        return itensCesta;
    }

    public void setItensCesta(List<ItemDaCesta> itensCesta) {
        this.itensCesta = itensCesta;
    }

    @Override
    public String toString() {
        return "Cesta{" +
                "codigo=" + codigo +
                ", alimentoDoado=" + alimentoDoado +
                ", dataCesta=" + dataCesta +
                ", itensCesta=" + itensCesta +
                '}';
    }
}
