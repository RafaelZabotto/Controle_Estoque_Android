package br.com.rafael.controleestoque.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;

public class AlimentoDAO {

    private final ConexaoSQLite conexaoSQLite;

    public AlimentoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarAlimentoDAO(Alimento alimento){

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try{

            ContentValues values = new ContentValues();
            values.put("nome",alimento.getNome());
            values.put("validade",alimento.getValidade());
            values.put("dataCadastro",alimento.getData_inseriu());
            values.put("quantidade",alimento.getQtdEstoque());

            long idAlimentoInserido = db.insert("alimento", null, values);

            return idAlimentoInserido;

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(db != null){
                db.close();
            }
        }
        return 0;

    }

    public List<Alimento> listarAlimentosDAO(){

        List<Alimento> listarAlimentos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT nome, COUNT(id) FROM alimento GROUP BY nome ";

        try {

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    //alimento.setCodigo(cursor.getInt(0));
                    alimento.setNome(cursor.getString(0));
                    alimento.setQtdEstoque(cursor.getInt(1));
                    //alimento.setValidade(cursor.getString(2));
                    //alimento.setData_inseriu(cursor.getString(3));
                    //alimento.setQtdEstoque(cursor.getInt(4));

                    listarAlimentos.add(alimento);

                }while(cursor.moveToNext());
            }

        }catch (Exception e){
            Log.d("ERRO LISTA DE ALIMENTOS", "Erro ao retornar os alimentos");
            return null;

        }finally {
            if(db != null){
                db.close();
            }
        }

        return listarAlimentos;
    }

    public List<Alimento> listarAlimentosCestaDAO(){

        List<Alimento> listarAlimentosCesta = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM ((select * from alimento where nome like 'Arroz'LIMIT 5)) UNION\n" +
                       "SELECT * FROM ((select * from alimento where nome like 'Leite' LIMIT 5)) UNION\n" +
                       "SELECT * FROM ((select * from alimento where nome like 'Molho de Tomate' LIMIT 5)) UNION\n" +
                       "SELECT * FROM ((select * from alimento where nome like 'Sal' LIMIT 5)) UNION\n" +
                       "SELECT * FROM ((select * from alimento where nome like 'Óleo' LIMIT 5)) " +
                       "ORDER BY nome, validade;";

        try{

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setCodigo(cursor.getInt(0));
                    alimento.setNome(cursor.getString(1));
                    alimento.setValidade(cursor.getString(2));
                    //alimento.setQtdEstoque(cursor.getInt(3));


                    listarAlimentosCesta.add(alimento);

                }while(cursor.moveToNext());
            }

        }catch(Exception e){
            Log.d("ERRO LISTA DE ALIMENTOS", "Erro ao retornar os alimentos");
            return null;

        }finally {
            if(db != null){
                db.close();
            }
        }

        return listarAlimentosCesta;
    }


    public List<Alimento> listarAlimentoVencimentoDAO(){

        List<Alimento> listarAlimentosVencidos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM alimento WHERE validade < DATE('NOW','+30 day') AND validade >= DATE('NOW');";

        try{

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setCodigo(cursor.getInt(0));
                    alimento.setNome(cursor.getString(1));
                    alimento.setValidade(cursor.getString(2));

                    listarAlimentosVencidos.add(alimento);

                }while(cursor.moveToNext());
            }

        }catch (Exception e){
            Log.d("ERRO LISTA DE ALIMENTOS", "Erro ao retornar os alimentos");
            return null;

        }finally {
            if(db != null){
                db.close();
            }
        }

        return listarAlimentosVencidos;

    }

    public List<Alimento> listarAlimentoInseridoDAO(){

        List<Alimento> listarAlimentosInseridos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM alimento WHERE validade LIKE DATE('NOW');";

        try{

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setCodigo(cursor.getInt(0));
                    alimento.setNome(cursor.getString(1));
                    alimento.setValidade(cursor.getString(2));

                    listarAlimentosInseridos.add(alimento);

                }while(cursor.moveToNext());
            }

        }catch (Exception e){
            Log.d("ERRO LISTA DE ALIMENTOS", "Erro ao retornar os alimentos");
            return null;

        }finally {
            if (db != null) {
                db.close();
            }
        }

        return listarAlimentosInseridos;
    }
}
