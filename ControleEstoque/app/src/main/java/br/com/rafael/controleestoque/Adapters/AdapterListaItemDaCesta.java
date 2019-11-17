package br.com.rafael.controleestoque.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.rafael.controleestoque.Model.ItemDaCesta;
import br.com.rafael.controleestoque.R;

public class AdapterListaItemDaCesta extends BaseAdapter {

    private Context context;
    private List<ItemDaCesta> itemDaCestaList;

    public AdapterListaItemDaCesta(Context context, List<ItemDaCesta> itemDaCestaList) {
        this.context = context;
        this.itemDaCestaList = itemDaCestaList;
    }

    @Override
    public int getCount() {
        return this.itemDaCestaList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.itemDaCestaList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    public boolean removerItemdaCesta(int posicao){
        this.itemDaCestaList.remove(posicao);
        notifyDataSetChanged();

        return true;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View v = View.inflate(this.context, R.layout.layout_carrinho_cesta, null);

        TextView txtNomeAlimento = v.findViewById(R.id.txtNomeAlimentoCarrinho);
        TextView txtCodigo = v.findViewById(R.id.txtIdCarrinho);
        TextView txtValidade = v.findViewById(R.id.txtValidadeItemCesta);

        txtNomeAlimento.setText(this.itemDaCestaList.get(posicao).getNome());
        txtCodigo.setText(String.valueOf(this.itemDaCestaList.get(posicao).getCodigoAlimento()));
        txtValidade.setText(this.itemDaCestaList.get(posicao).getValidade());

        return v;
    }

    /*Adiciona Item ao Carrinho */
    public void addItemDoCarrinho(ItemDaCesta itemDaCesta_2){

        this.itemDaCestaList.add(itemDaCesta_2);
        this.notifyDataSetChanged();
    }

    /*
    * Atualiza a lista de produtos
    *
    */

    public void atualizar(List<ItemDaCesta> itemDaCesta_2){
        this.itemDaCestaList.clear();
        this.itemDaCestaList = itemDaCesta_2;
        this.notifyDataSetChanged();
    }
}
