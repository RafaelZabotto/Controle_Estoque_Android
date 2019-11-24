package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import br.com.rafael.controleestoque.Adapters.AdapterListaSemanal;
import br.com.rafael.controleestoque.Adapters.AdapterListaVencimentos;
import br.com.rafael.controleestoque.Controller.AlimentoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class ListAlimentoVencimentoView extends AppCompatActivity {

    private ListView lsvSemanal;
    private List<Alimento> alimentoList;
    private AdapterListaVencimentos adapterListaVencimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alimento_vencimento_view);

        AlimentoController alimentoController =
                new AlimentoController(ConexaoSQLite.getInstaciaConexao(ListAlimentoVencimentoView.this));

        alimentoList = alimentoController.listarAlimentoVencido();

        Log.d("puto",alimentoList.toString());

        this.lsvSemanal = findViewById(R.id.lsvVencimentos);
        this.adapterListaVencimentos = new AdapterListaVencimentos(ListAlimentoVencimentoView.this, this.alimentoList);
        this.lsvSemanal.setAdapter(this.adapterListaVencimentos);
    }
}
