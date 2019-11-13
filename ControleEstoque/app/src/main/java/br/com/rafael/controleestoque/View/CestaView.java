package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rafael.controleestoque.Adapters.AdapterListaItemDaCesta;
import br.com.rafael.controleestoque.Controller.AlimentoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.Model.ItemDaCesta;
import br.com.rafael.controleestoque.R;

public class CestaView extends AppCompatActivity {

    private Spinner spnAlimentoCesta;
    private List<Alimento> listaAlimento;
    private AlimentoController alimentoController;
    private Button btnAdicionarCesta;
    private Button btnFinalizarCesta;

    private ListView lsvMontandoCesta;
    private List<ItemDaCesta> itemDaCestaList_2;
    private AdapterListaItemDaCesta adapterListaItemDaCesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta_view);

        //Spinner vai trazer alimentos do banco ====================================================

        this.alimentoController = new AlimentoController(ConexaoSQLite.getInstaciaConexao(this));
        this.listaAlimento = this.alimentoController.listarAlimentosCesta();

        this.spnAlimentoCesta = findViewById(R.id.spnCesta);
        ArrayAdapter<Alimento> spnAlimentoAdapter = new ArrayAdapter<Alimento>(
                this,android.R.layout.simple_spinner_item, listaAlimento);

        this.spnAlimentoCesta.setAdapter(spnAlimentoAdapter);
        //==========================================================================================

        //Referentes a cesta
        this.lsvMontandoCesta = findViewById(R.id.lsvCesta);
        this.itemDaCestaList_2 = new ArrayList<>();
        this.adapterListaItemDaCesta = new AdapterListaItemDaCesta(CestaView.this, this.itemDaCestaList_2);
        this.lsvMontandoCesta.setAdapter(this.adapterListaItemDaCesta);

        this.lsvMontandoCesta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int posicao, long id) {

                final ItemDaCesta itemDaCesta = (ItemDaCesta) adapterListaItemDaCesta.getItem(posicao);

                AlertDialog.Builder opcoes = new AlertDialog.Builder(CestaView.this);
                opcoes.setTitle("Atenção: ");
                opcoes.setMessage("Deseja remover o item " + itemDaCesta.getNome() + "?");

                opcoes.setNegativeButton("Não", null);
                opcoes.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean removeu = false;

                        removeu = adapterListaItemDaCesta.removerItemdaCesta(posicao);

                        if(removeu){
                            Toast.makeText(CestaView.this, "Item retirado da Cesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                opcoes.create().show();
            }
        });

    }


    /*Adiciona ao Cesta*/
    public void eventAdicionaAlimento(View view){

       
        ItemDaCesta itemDaCesta = new ItemDaCesta();
        Alimento alimentoSelecionado = (Alimento) this.spnAlimentoCesta.getSelectedItem();

        itemDaCesta.setNome(alimentoSelecionado.getNome());
        itemDaCesta.setCodigo(alimentoSelecionado.getCodigo());
        itemDaCesta.setValidade(alimentoSelecionado.getValidade());

        this.adapterListaItemDaCesta.addItemDoCarrinho(itemDaCesta);

    }




}
