package br.com.rafael.controleestoque.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class AdapterListaVencimentos extends BaseAdapter {

    private Context context;
    private List<Alimento> alimentoList;

    public AdapterListaVencimentos(Context context, List<Alimento> alimentoList) {
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
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View v = View.inflate(this.context, R.layout.layout_vencimentos, null);

        TextView txtNomeVenc = v.findViewById(R.id.txtVencNome);
        TextView txtCodigoVenc = v.findViewById(R.id.txtVencCodigo);
        TextView txtValidadevenc = v.findViewById(R.id.txtValidaVenc);

        txtNomeVenc.setText(this.alimentoList.get(posicao).getNome());
        txtValidadevenc.setText(this.alimentoList.get(posicao).getValidade());
        txtCodigoVenc.setText(String.valueOf(this.alimentoList.get(posicao).getCodigo()));

        return v;

    }
}
