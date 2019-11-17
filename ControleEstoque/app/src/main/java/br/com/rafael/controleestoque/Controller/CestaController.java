package br.com.rafael.controleestoque.Controller;

import br.com.rafael.controleestoque.DAO.CestaDAO;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Cesta;

public class CestaController {

    private final CestaDAO cestaDAO;

    public CestaController(ConexaoSQLite conexaoSQLite){

        cestaDAO = new CestaDAO(conexaoSQLite);
    }

    public long salvarCestaController(Cesta cesta){
        return cestaDAO.salvarCestaDAO(cesta);
    }

    public boolean salvarItensCestaController(Cesta cesta){
        return cestaDAO.salvarItemDaCestaDAO(cesta);
    }
}
