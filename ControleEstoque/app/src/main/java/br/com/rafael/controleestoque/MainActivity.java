package br.com.rafael.controleestoque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.View.AddVicentinoView;
import br.com.rafael.controleestoque.View.ListVicentinoView;
import br.com.rafael.controleestoque.View.MenuView;

public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private Button cadastrar;
    private Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btnIniciar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, MenuView.class);
                startActivity(it);
            }
        });

        cadastrar = findViewById(R.id.btnCadastroVicentinos);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, AddVicentinoView.class);
                startActivity(it);
            }
        });

        listar = findViewById(R.id.btnListarVicentinos);

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, ListVicentinoView.class);
                startActivity(it);

            }
        });
    }
}
