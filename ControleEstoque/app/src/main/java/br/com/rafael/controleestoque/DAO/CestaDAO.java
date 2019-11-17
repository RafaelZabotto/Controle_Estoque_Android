package br.com.rafael.controleestoque.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;

import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Cesta;
import br.com.rafael.controleestoque.Model.ItemDaCesta;

public class CestaDAO {

    private final ConexaoSQLite conexaoSQLite;

    public CestaDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarCestaDAO(Cesta cesta){

        SQLiteDatabase database = conexaoSQLite.getWritableDatabase();

        try{

            ContentValues values = new ContentValues();

            values.put("data", cesta.getDataCesta().getTime());

            long idCestaInserida = database.insert("cesta", null,values);

            return idCestaInserida;

        }catch(Exception e){
            e.printStackTrace();

        }finally {
            if(database != null){
                database.close();
            }
        }

        return 0;

    }

    public boolean salvarItemDaCestaDAO(Cesta cesta){

        SQLiteDatabase database = conexaoSQLite.getWritableDatabase();

        try{

            ContentValues values = null;

            for (ItemDaCesta itemDaCesta:cesta.getItensCesta()) {

                values = new ContentValues();
                values.put("id_alimento", itemDaCesta.getCodigoAlimento());
                values.put("id_cesta", itemDaCesta.getCodigo());

                database.insert("item_cesta", null, values);
            }

            return true;

        }catch(Exception e){
            e.printStackTrace();

        }finally {
            database.close();

        }

        return false;
    }
}
