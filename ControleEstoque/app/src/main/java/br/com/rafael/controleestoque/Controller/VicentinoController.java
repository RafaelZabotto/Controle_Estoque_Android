package br.com.rafael.controleestoque.Controller;

import java.util.List;

import br.com.rafael.controleestoque.DAO.VicentinoDAO;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Vicentino;

public class VicentinoController {

    private final VicentinoDAO vicentinoDAO;

    public VicentinoController(ConexaoSQLite aConexaoSQLite) {
        this.vicentinoDAO = new VicentinoDAO(aConexaoSQLite);
    }

    public long salvarVicentino(Vicentino vicentino){
        return this.vicentinoDAO.salvarVicentinoDAO(vicentino);
    }

    public Vicentino autenticarVicentino(String email, String senha){
        return this.vicentinoDAO.autenticarVicentinoDAO(email,senha);
    }
}
