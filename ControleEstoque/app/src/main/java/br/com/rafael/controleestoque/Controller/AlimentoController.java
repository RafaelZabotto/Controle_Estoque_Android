package br.com.rafael.controleestoque.Controller;

import java.util.List;

import br.com.rafael.controleestoque.DAO.AlimentoDAO;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;

public class AlimentoController {

    private final AlimentoDAO alimentoDAO;

    public AlimentoController(ConexaoSQLite aConexaoSQLite) {
       alimentoDAO = new AlimentoDAO(aConexaoSQLite);
    }

    public long salvarAlimento(Alimento halimento){
        return this.alimentoDAO.salvarAlimentoDAO(halimento);
    }

    public List<Alimento> listarAlimentos(){
        return this.alimentoDAO.listarAlimentosDAO();
    }

    public List<Alimento> listarAlimentosCesta(){
        return this.alimentoDAO.listarAlimentosCestaDAO();
    }

    public List<Alimento> listarAlimentoVencido(){
        return this.alimentoDAO.listarAlimentoVencimentoDAO();
    }

    public List<Alimento> listarAlimentoInserido(){
        return this.alimentoDAO.listarAlimentoInseridoDAO();
    }

}
