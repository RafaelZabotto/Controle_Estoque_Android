package br.com.rafael.controleestoque.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.rafael.controleestoque.Model.Vicentino;
import br.com.rafael.controleestoque.R;

public class AdapterListaVicentino extends BaseAdapter {

    private Context context;
    private List<Vicentino> vicentinoList;

    public AdapterListaVicentino(Context context, List<Vicentino> vicentinoList) {
        this.context = context;
        this.vicentinoList = vicentinoList;
    }

    @Override
    public int getCount() {
        return this.vicentinoList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.vicentinoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(this.context, R.layout.layout_vicentino, null);

        TextView txtNomeVicentino = v.findViewById(R.id.txtNomeVicentino);
        TextView txtEmailVicentino = v.findViewById(R.id.txtEmailVicentino);

        txtNomeVicentino.setText(this.vicentinoList.get(i).getNome());
        txtEmailVicentino.setText(String.valueOf(this.vicentinoList.get(i).getEmail()));


        return v;
    }
}
