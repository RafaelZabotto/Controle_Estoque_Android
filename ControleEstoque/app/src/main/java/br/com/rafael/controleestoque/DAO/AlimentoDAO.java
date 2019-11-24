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

        String query = "SELECT a.nome, COUNT(a.nome) " +
                "FROM alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento " +
                "WHERE b.id_alimento is NULL " +
                "GROUP BY a.nome";

        try {

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setNome(cursor.getString(0));
                    alimento.setQtdEstoque(cursor.getInt(1));

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

        String query ="SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Achocolatado' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Açúcar Cristal' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Açúcar Refinado' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Arroz' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Bala' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Bolacha Água e Sal' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Bolacha Maizena' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Bolo' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Bombril' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Café' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Detergente' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Ervilha' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Farinha Mandioca' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Farinha Milho' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Farinha Trigo' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Farofa' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Feijão' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Fubá' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Gelatina' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Goiabada' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Leite' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Leite em pó' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Macarrão' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Milho em lata' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Molho de tomate' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Óleo' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Papel Higiênico' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Pasta de Dentes' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Sabão em Barras' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Sabão em Pó' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Sal' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Salsicha' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Sardinha' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Seleta de Legumes' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Tempero' LIMIT 5)) UNION\n" +
                      "SELECT * FROM ((select STRFTIME('%d/%m/%Y', a.validade), * from alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL AND a.nome like 'Vinagre' LIMIT 5)) " +
                      "ORDER BY nome, validade;";


        try{

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setCodigo(cursor.getInt(1));
                    alimento.setNome(cursor.getString(2));
                    alimento.setValidade(cursor.getString(0));

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

        String query = "SELECT strftime('%d/%m/%Y', a.validade), * " +
                "FROM alimento a LEFT JOIN item_cesta b ON a.id = b.id_alimento WHERE b.id_alimento IS NULL " +
                "AND a.validade >= DATE('NOW') AND a.validade < DATE('NOW','+30 day') ORDER BY a.validade;";

        try{

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setCodigo(cursor.getInt(1));
                    alimento.setNome(cursor.getString(2));
                    alimento.setValidade(cursor.getString(0));

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

        String query = "SELECT strftime('%d/%m/%Y', a.validade), strftime('%d/%m/%Y', a.dataCadastro), * " +
                "FROM alimento a WHERE dataCadastro <= DATE('NOW') AND dataCadastro <= DATE('NOW','+7 day')" +
                "ORDER BY dataCadastro desc;";

        try{

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){

                Alimento alimento = new Alimento();

                do {

                    alimento = new Alimento();
                    alimento.setCodigo(cursor.getInt(2));
                    alimento.setNome(cursor.getString(3));
                    alimento.setValidade(cursor.getString(0));
                    alimento.setData_inseriu(cursor.getString(1));

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
