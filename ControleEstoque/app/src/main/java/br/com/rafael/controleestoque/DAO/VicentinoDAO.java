package br.com.rafael.controleestoque.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Vicentino;

public class VicentinoDAO {

    private final ConexaoSQLite conexaoSQLite;

    public VicentinoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarVicentino(Vicentino vicentino){

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try{


        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(db != null){
                db.close();
            }
        }
        return 0;

    }

    public List<Vicentino> listarVicentinos(){


        List<Vicentino> listarVicentinos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM vicentino;";

        try {

            cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()){

                Vicentino vicentino = new Vicentino();

                do {

                    vicentino = new Vicentino();
                    vicentino.setNome(cursor.getString(1));
                    vicentino.setEmail(cursor.getString(3));

                    listarVicentinos.add(vicentino);

                }while(cursor.moveToNext());
            }

        }catch (Exception e){
            Log.d("ERRO LISTA DE USUÁRIOS", "Erro ao retornar os usuários");
            return null;

        }finally {
            if(db != null){
                db.close();
            }
        }


        return listarVicentinos;
    }
}
