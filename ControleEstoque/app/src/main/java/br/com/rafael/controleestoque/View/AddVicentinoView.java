package br.com.rafael.controleestoque.View;

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
import br.com.rafael.controleestoque.R;

public class AddVicentinoView extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnInserirVicentino;

    private Vicentino vicentino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vicentino_view);

        edtNome = findViewById(R.id.edtNomeV);
        edtEmail = findViewById(R.id.edtEmailV);
        edtSenha = findViewById(R.id.edtSenhaV);
        btnInserirVicentino = findViewById(R.id.btnInserirVicentino);

        this.clickInserirVicentinoListener();
    }

    private void clickInserirVicentinoListener(){

        this.btnInserirVicentino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vicentino inserirVicentino = getDadosCadastroVicentino();

                if(inserirVicentino != null){

                    VicentinoController vicentinoController =
                            new VicentinoController(ConexaoSQLite.getInstaciaConexao(AddVicentinoView.this));

                    //inserindo vicentino
                    final long condigoVicentino = vicentinoController.salvarVicentino(inserirVicentino);

                    if(condigoVicentino > 0){

                        Toast.makeText(AddVicentinoView.this, "Vicentino criado com sucesso",Toast.LENGTH_LONG).show();

                    }else{

                        Toast.makeText(AddVicentinoView.this, "Não foi possível salvar",Toast.LENGTH_LONG).show();
                    }

                    finish();

                }else{
                    Toast.makeText(AddVicentinoView.this, "Campos Obrigatórios",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private Vicentino getDadosCadastroVicentino(){

        this.vicentino = new Vicentino();

        //validação nome
        if(this.edtNome.getText().toString().isEmpty() == false){
            this.vicentino.setNome(this.edtNome.getText().toString());
        }else{
            return null;
        }

        //valdiação email
        if(this.edtEmail.getText().toString().isEmpty() == false){
            this.vicentino.setEmail(this.edtEmail.getText().toString());
        }else{
            return null;
        }

        //validação senha
        if(this.edtSenha.getText().toString().isEmpty() == false){
            this.vicentino.setSenha(this.edtSenha.getText().toString());
        }else{
            return null;
        }

        return vicentino;
    }
}
