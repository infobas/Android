package devandroid.helio.applistacursojava.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.helio.applistacursojava.R;
import devandroid.helio.applistacursojava.controller.PessoaController;
import devandroid.helio.applistacursojava.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller; //controladora

    Pessoa pessoa; //classe Pessoa objeto pessoa é um tipo de dado
    Pessoa outraPessoa; //Classe Pessoa objeto outraPessoa é usado para sets

    String dadosPessoa; //pascal case e camel case
    String dadosOutraPessoa; // gets

    EditText editPrimeiroNome; //classe EditText objeto editPrimeiroNome
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnlimpar;
    Button btnsalvar;
    Button btnfinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        controller = new PessoaController(); //controladora
        controller.toString();


        pessoa = new Pessoa();
        //atribuir dados ao objeto conforme modelo template
        pessoa.setPrimeiroNome("Álvaro");
        pessoa.setSobreNome("B.P. Basilone Paiva");
        pessoa.setCursoDesejado("Robótica Aplicada");
        pessoa.setTelefoneContato("19 9911224455");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Marcelo");
        outraPessoa.setSobreNome("Cabelo de Buneca");
        outraPessoa.setCursoDesejado("Analise em Android");
        outraPessoa.setTelefoneContato("19 9911224466");

        //tela do dispositivo
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);
        btnfinal = findViewById(R.id.btnfinal);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());


        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

            }
        });

        btnfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Logo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "SALVO!" + pessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);


            }
        });


        // fim tela

/*
        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome(); //opção += concatena
        dadosPessoa += "Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += "Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += "Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += pessoa.getPrimeiroNome(); //opção += concatena
        dadosOutraPessoa += "Sobrenome: ";
        dadosOutraPessoa += pessoa.getSobreNome();
        dadosOutraPessoa += "Curso Desejado: ";
        dadosOutraPessoa += pessoa.getCursoDesejado();
        dadosOutraPessoa += "Telefone de Contato: ";
        dadosOutraPessoa += pessoa.getTelefoneContato();

 */

        Log.i("POO Adroid", "obj pessoa: " + pessoa.toString());
        Log.i("POO Adroid", "obj outrapessoa: " + outraPessoa.toString());

    }
}