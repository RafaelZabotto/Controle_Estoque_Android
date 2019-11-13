package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.rafael.controleestoque.Adapters.AdapterListaAlimento;
import br.com.rafael.controleestoque.Controller.AlimentoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class ListAlimentoView extends AppCompatActivity {

    private ListView lsvAlimentos;
    private List<Alimento> alimentoList;
    private AdapterListaAlimento adapterListaAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alimento_view);

        AlimentoController alimentoController =
                new AlimentoController(ConexaoSQLite.getInstaciaConexao(ListAlimentoView.this));

        alimentoList = alimentoController.listarAlimentos();


        this.lsvAlimentos = findViewById(R.id.lstAlimentos);

        this.adapterListaAlimento = new AdapterListaAlimento(ListAlimentoView.this, this.alimentoList);

        this.lsvAlimentos.setAdapter(this.adapterListaAlimento);
    }
}
