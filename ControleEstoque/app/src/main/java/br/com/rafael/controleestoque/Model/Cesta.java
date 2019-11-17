package br.com.rafael.controleestoque.Model;

import java.util.Date;
import java.util.List;

public class Cesta {

    private long codigo;
    private Date dataCesta;
    private List<ItemDaCesta> itensCesta;

    public Cesta() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
                ", dataCesta=" + dataCesta +
                ", itensCesta=" + itensCesta +
                '}';
    }
}
