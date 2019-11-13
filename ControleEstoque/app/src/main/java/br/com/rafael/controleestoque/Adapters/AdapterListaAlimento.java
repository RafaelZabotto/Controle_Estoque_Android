package br.com.rafael.controleestoque.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class AdapterListaAlimento extends BaseAdapter {

    private Context context;
    private List<Alimento> alimentoList;

    public AdapterListaAlimento(Context context, List<Alimento> alimentoList) {
        this.context = context;
        this.alimentoList = alimentoList;
    }

    @Override
    public int getCount() {
        return this.alimentoList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.alimentoList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    public void removerAlimento(int posicao){
        this.alimentoList.remove(posicao);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View v = View.inflate(this.context, R.layout.layout_alimento, null);

        TextView txtNomeAlimento = v.findViewById(R.id.txtNomeAlimento);
        TextView txtQuantidade = v.findViewById(R.id.txtQuantidade);

        txtNomeAlimento.setText(this.alimentoList.get(posicao).getNome());
        txtQuantidade.setText(String.valueOf(this.alimentoList.get(posicao).getQtdEstoque()));

        return v;
    }
}
