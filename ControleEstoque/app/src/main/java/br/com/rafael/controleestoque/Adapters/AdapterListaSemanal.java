package br.com.rafael.controleestoque.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class AdapterListaSemanal extends BaseAdapter {

    private Context context;
    private List<Alimento> alimentoList;

    public AdapterListaSemanal(Context context, List<Alimento> alimentoList) {
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

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View v = View.inflate(this.context, R.layout.layout_semanal, null);

        TextView txtNomeSemanal = v.findViewById(R.id.txtNomeSemanal);
        TextView txtDataInsercao = v.findViewById(R.id.txtInsercaoSemanal);
        TextView txtDatavalidade = v.findViewById(R.id.txtValdiadeSemanal);
        TextView txtCodigoSemanal = v.findViewById(R.id.txtCodigoSemanal);

        txtNomeSemanal.setText(this.alimentoList.get(posicao).getNome());
        txtDataInsercao.setText(this.alimentoList.get(posicao).getData_inseriu());
        txtDatavalidade.setText(this.alimentoList.get(posicao).getValidade());
        txtCodigoSemanal.setText(String.valueOf(this.alimentoList.get(posicao).getCodigo()));

        return v;

    }
}
