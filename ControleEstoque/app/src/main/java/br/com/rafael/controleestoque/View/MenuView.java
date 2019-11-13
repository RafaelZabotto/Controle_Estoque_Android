package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.ImageView;

import br.com.rafael.controleestoque.R;

public class MenuView extends AppCompatActivity {

    private ImageView addAlimento;
    private ImageView removeAlimento;
    private ImageView storageConsult;
    private ImageView dateConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);

        addAlimento    = findViewById(R.id.imgAdd);
        removeAlimento = findViewById(R.id.imgRemove);
        storageConsult = findViewById(R.id.imgStorage);
        dateConsult    = findViewById(R.id.imgDate);

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
