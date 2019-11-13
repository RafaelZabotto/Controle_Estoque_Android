package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.rafael.controleestoque.Adapters.AdapterListaVicentino;
import br.com.rafael.controleestoque.Model.Vicentino;
import br.com.rafael.controleestoque.R;

public class ListVicentinoView extends AppCompatActivity {


    private ListView lsvVicentinos;
    private List<Vicentino> vicentinoList;
    private AdapterListaVicentino adapterListaVicentino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vicentino_view);


    }
}
