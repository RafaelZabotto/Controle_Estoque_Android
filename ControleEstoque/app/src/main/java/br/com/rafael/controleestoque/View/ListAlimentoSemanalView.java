package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.rafael.controleestoque.Adapters.AdapterListaAlimento;
import br.com.rafael.controleestoque.Adapters.AdapterListaSemanal;
import br.com.rafael.controleestoque.Controller.AlimentoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class ListAlimentoSemanalView extends AppCompatActivity {

    private ListView lsvSemanal;
    private List<Alimento> alimentoList;
    private AdapterListaSemanal adapterListaSemanal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alimento_semanal_view);

        AlimentoController alimentoController =
                new AlimentoController(ConexaoSQLite.getInstaciaConexao(ListAlimentoSemanalView.this));

        alimentoList = alimentoController.listarAlimentoInserido();

        this.lsvSemanal = findViewById(R.id.lsvSemanal);
        this.adapterListaSemanal = new AdapterListaSemanal(ListAlimentoSemanalView.this, this.alimentoList);
        this.lsvSemanal.setAdapter(this.adapterListaSemanal);


    }
}
