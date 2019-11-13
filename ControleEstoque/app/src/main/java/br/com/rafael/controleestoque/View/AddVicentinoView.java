package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    private Button inserirVicentino;

    private Vicentino vicentino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vicentino_view);

        edtNome = findViewById(R.id.edtNomeV);
        edtEmail = findViewById(R.id.edtEmailV);
        edtSenha = findViewById(R.id.edtSenhaV);
        inserirVicentino = findViewById(R.id.btnInserirAlimento);

       // this.clickInserirListener();

    }

    /*private void clickInserirListener(){

        this.inserirVicentino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vicentino vicentinoInserido = new Vicentino();

                VicentinoController vicentinoController =
                        new VicentinoController(ConexaoSQLite.getInstaciaConexao(AddVicentinoView.this));

                long codigoVicentino = vicentinoController.salvarVicentino(vicentinoInserido);

                if (codigoVicentino > 0) {

                    Toast.makeText(AddVicentinoView.this, "Vicentino Salvo com sucesso", Toast.LENGTH_LONG).show();

                }
            }
        });
    }*/

    //VALIDAÇÃO dos cam
}
