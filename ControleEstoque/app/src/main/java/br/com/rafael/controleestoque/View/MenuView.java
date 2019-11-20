package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import br.com.rafael.controleestoque.Adapters.AdapterListaAlimento;
import br.com.rafael.controleestoque.Controller.AlimentoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class MenuView extends AppCompatActivity {

    private ImageView addAlimento;
    private ImageView removeAlimento;
    private ImageView storageConsult;
    private ImageView dateConsult;

    private AdapterListaAlimento adapterListaAlimento;
    private List<Alimento> alimentoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);

        AlimentoController alimentoController =
                new AlimentoController(ConexaoSQLite.getInstaciaConexao(MenuView.this));

        alimentoList = alimentoController.listarAlimentos();

        this.adapterListaAlimento = new AdapterListaAlimento(MenuView.this, this.alimentoList);

        int teste = adapterListaAlimento.getCount();


        addAlimento    = findViewById(R.id.imgAdd);
        removeAlimento = findViewById(R.id.imgRemove);
        storageConsult = findViewById(R.id.imgStorage);
        dateConsult    = findViewById(R.id.imgDate);

        if(teste > 0){
            dateConsult.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.calendar_not_ok));
        }else{
            dateConsult.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.calendar_ok));
        }

        addAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MenuView.this, AddAlimentoView.class);
                startActivity(it);
            }
        });

        removeAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it  = new Intent(MenuView.this, CestaView.class);
                startActivity(it);
            }
        });

        storageConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MenuView.this, ListAlimentoView.class);
                startActivity(it);

            }
        });

        dateConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
