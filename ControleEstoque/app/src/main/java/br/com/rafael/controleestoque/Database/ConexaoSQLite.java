package br.com.rafael.controleestoque.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexaoSQLite extends SQLiteOpenHelper {

    private static ConexaoSQLite INSTACIA_CONEXAO;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "estoque";

    public ConexaoSQLite(@Nullable Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    //Método Singleton para instanciar apenas uma vez a conexão
    public static ConexaoSQLite getInstaciaConexao(Context context){
        if(INSTACIA_CONEXAO == null){
            INSTACIA_CONEXAO = new ConexaoSQLite(context);
        }

        return INSTACIA_CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlTabelaAlimento =
                "CREATE TABLE IF NOT EXISTS alimento" +
                    "(" +
                    "id INTEGER PRIMARY KEY," +
                        "nome TEXT," +
                        "validade DATE," +
                        "dataCadastro DATE," +
                        "quantidade INTEGER" +
                    ")";
        
        sqLiteDatabase.execSQL(sqlTabelaAlimento);

        /*String sqlTabelaVicentino =
                "CREATE TABLE IF NOT EXISTS vicentino" +
                        "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "nome TEXT," +
                            "email TEXT," +
                            "login TEXT," +
                            "senha TEXT" +
                        ")";

        sqLiteDatabase.execSQL(sqlTabelaVicentino);*/

        String sqlTabelaCesta =
                "CREATE TABLE IF NOT EXISTS cesta" +
                        "(" +
                        "id INTEGER PRIMARY KEY," +
                        "data  INTEGER" +
                        ")";

        sqLiteDatabase.execSQL(sqlTabelaCesta);

        String sqlTabelaItemCesta =
                "CREATE TABLE IF NOT EXISTS item_cesta" +
                        "(" +
                        "id INTEGER PRIMARY KEY," +
                        "quantidade INTEGER," +
                        "id_alimento INTEGER," +
                        "id_cesta INTEGER" +
                        ")" ;

        sqLiteDatabase.execSQL(sqlTabelaItemCesta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
