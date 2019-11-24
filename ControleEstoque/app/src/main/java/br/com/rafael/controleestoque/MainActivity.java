package br.com.rafael.controleestoque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafael.controleestoque.Controller.VicentinoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Vicentino;
import br.com.rafael.controleestoque.View.AddVicentinoView;
import br.com.rafael.controleestoque.View.ListVicentinoView;
import br.com.rafael.controleestoque.View.MenuView;

public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private Button cadastrar;
    private Button entrar;

    private EditText edtEmailLogin;
    private EditText edtSenhaLogin;

    private Vicentino vicentino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btnIniciar);
        cadastrar = findViewById(R.id.btnCadastroVicentinos);
        entrar = findViewById(R.id.btnEntrar);

        edtEmailLogin = findViewById(R.id.edtNomeLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtEmailLogin.getText().toString();
                String senha = edtSenhaLogin.getText().toString();

                VicentinoController vicentinoController =
                        new VicentinoController(ConexaoSQLite.getInstaciaConexao(MainActivity.this));

                Vicentino vicentinoEncontrado = vicentinoController.autenticarVicentino(email,senha);

                if(vicentinoEncontrado != null){

                    Intent it = new Intent(MainActivity.this,MenuView.class);
                    startActivity(it);

                    Toast.makeText(MainActivity.this,"Vicentino Logado", Toast.LENGTH_LONG).show();
                    finish();

                }else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Atenção");
                    builder.setMessage("Vicentino não encontrado!");

                    builder.setPositiveButton("Ok",null);
                    builder.create().show();
                }
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, MenuView.class);
                startActivity(it);
            }
        });

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, AddVicentinoView.class);
                startActivity(it);
            }
        });

    }
}
