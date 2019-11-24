package br.com.rafael.controleestoque.DAO;

import android.content.ContentValues;
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

    public long salvarVicentinoDAO(Vicentino vicentino){

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try{

            ContentValues values = new ContentValues();
            values.put("nome",vicentino.getNome());
            values.put("email",vicentino.getEmail());
            values.put("senha",vicentino.getSenha());

            long idVicentinoInserido = db.insert("vicentino", null,values);

            return idVicentinoInserido;

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(db != null){
                db.close();
            }
        }
        return 0;

    }

   public Vicentino autenticarVicentinoDAO(String email,String senha){

        SQLiteDatabase db = conexaoSQLite.getReadableDatabase();

        final String[] propriedades = {"id","nome","email","senha"};

        Cursor cursor = db.query("vicentino",propriedades,"email = ? AND senha = ?",
                new String[] {email,senha},null, null, null, null);

        if(cursor.moveToFirst()){

            Vicentino vicentino = new Vicentino();

            vicentino.setCodigo(Integer.parseInt(cursor.getString(0)));
            vicentino.setNome(cursor.getString(1));
            vicentino.setEmail(cursor.getString(2));
            vicentino.setSenha(cursor.getString(3));

            return vicentino;

        }else{
            return null;
        }
   }

}
