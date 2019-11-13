package br.com.rafael.controleestoque.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.rafael.controleestoque.Controller.AlimentoController;
import br.com.rafael.controleestoque.Database.ConexaoSQLite;
import br.com.rafael.controleestoque.Model.Alimento;
import br.com.rafael.controleestoque.R;

public class AddAlimentoView extends AppCompatActivity {

    private Spinner spnAlimento;
    private List<Alimento> listaAlimento;

    private Button inserirAlimento;

    private TextView edtDataValidade;
    private String validade_usual;

    private Alimento alimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alimento_view);


        /*Bloco de configuração do Spinner*/
        spnAlimento = findViewById(R.id.spnAlimento);

        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this, R.array.tipos_alimentos,
                        android.R.layout.simple_spinner_dropdown_item);

        spnAlimento.setAdapter(adapter);
        /*=============================================================================*/

        /*Bloco de Configuração do Date Picker Calendar*/

        edtDataValidade = findViewById(R.id.edtDataValidade);

        Calendar calendar = Calendar.getInstance();

        final int ano = calendar.get(Calendar.YEAR);
        final int mes = calendar.get(Calendar.MONTH);
        final int dia = calendar.get(Calendar.DAY_OF_MONTH);

        edtDataValidade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddAlimentoView.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                        mes = mes+1;
                        String date = dia+"/"+mes+"/"+ano;
                        validade_usual = ano+"-"+mes+"-"+dia;
                        edtDataValidade.setText(date);
                    }
                },ano,mes,dia);
                datePickerDialog.show();
            }
        });

        /*=============================================================================*/

        inserirAlimento = findViewById(R.id.btnInserirAlimento);

        this.clickInserirListener();

    }

    private void clickInserirListener(){

        this.inserirAlimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Alimento alimentoInserido = getDadosCadastroAlimento();

                if(alimentoInserido != null){

                    AlimentoController alimentoController =
                            new AlimentoController(ConexaoSQLite.getInstaciaConexao(AddAlimentoView.this));

                    long codigoAlimento = alimentoController.salvarAlimento(alimentoInserido);

                    if(codigoAlimento > 0){

                        Toast.makeText(AddAlimentoView.this, "Produto Salvo com sucesso",Toast.LENGTH_LONG).show();

                    }else{

                        Toast.makeText(AddAlimentoView.this, "Não foi possível salvar",Toast.LENGTH_LONG).show();
                    }


                }else{

                    Toast.makeText(AddAlimentoView.this, "Campos Obrigatórios",Toast.LENGTH_LONG).show();
                }



            }
        });
    }

    private Alimento getDadosCadastroAlimento() {

        this.alimento = new Alimento();

        if(this.spnAlimento.getSelectedItem().toString().isEmpty() == false){
            //Toast.makeText(AddAlimentoView.this, spnAlimento.toString(),Toast.LENGTH_LONG).show();
            this.alimento.setNome(spnAlimento.getSelectedItem().toString());
        }else{
            return null;
        }

        this.alimento.setValidade(validade_usual);

        //Inserção da data atual de cadastro do alimento

        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        String dataFormatada = formataData.format(data);

        this.alimento.setData_inseriu(dataFormatada);

        return alimento;
    }


}
