package devandroid.helio.applistacursojava.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import devandroid.helio.applistacursojava.R;
import devandroid.helio.applistacursojava.controller.CursoController;
import devandroid.helio.applistacursojava.controller.PessoaController;
import devandroid.helio.applistacursojava.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    //retirado para v3 e incluido em PessoaController.java
    /*
    SharedPreferences preferences;
    //torna shared  listaVip publico
    SharedPreferences.Editor listaVip;

    //comando abaixo psfs auto
    public static final String NOME_PREFERENCES = "pref_listavip";
    */
    //v1 v2 v3

    PessoaController controller; //controladora
    CursoController cursoController;

    Pessoa pessoa; //classe Pessoa objeto pessoa é um tipo de dado
    //Pessoa outraPessoa; //Classe Pessoa objeto outraPessoa é usado para sets

    List<String> nomeDosCursos;


    String dadosPessoa; //pascal case e camel case
    //String dadosOutraPessoa; // gets

    EditText editPrimeiroNome; //classe EditText objeto editPrimeiroNome
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnlimpar;
    Button btnsalvar;
    Button btnfinal;

    Spinner spinner;



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
        //retirado v3
        /*
        //criando local temporário para informações
        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        //SharedPreferences.Editor listaVip = preferences.edit();
        listaVip = preferences.edit(); //shared ficou publico acima
        */
        //abaixo foi necessário inserir MainActivity.this depois criar na luz vermelha e adicionar a sugestão
        controller = new PessoaController(MainActivity.this); //controladora
        controller.toString();




        pessoa = new Pessoa();
        //adicionado v3
        controller.buscar(pessoa);

        //nova aula v2
        //alterado v3
        /*
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));
        //fim v2
        */

        //retirado para evolução da aula
        /*
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
        */


        //tela do dispositivo
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);



        //nova aula v2
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());
        //v2

        btnlimpar = findViewById(R.id.btnlimpar); //setando o botao limpar com a classe main activity
        btnsalvar = findViewById(R.id.btnsalvar);
        btnfinal = findViewById(R.id.btnfinal);

        //adapter, layout, injetar adapter ao spinner para lista de cursos
        cursoController = new CursoController();
        nomeDosCursos = cursoController.dadosParaSpinner();

        spinner = findViewById(R.id.spinner);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);




        //retirado para evolução da aula
/*
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());
*/

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");
                //adinonado v3
                controller.limpar();
                //alterado v3
                /*
                listaVip.clear();
                listaVip.apply();
                */

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

                Toast.makeText(MainActivity.this, "SALVO!: " + pessoa.toString(), Toast.LENGTH_LONG).show();
                //retirado v3            //para salvar em local temporario
                /*
                listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome",pessoa.getSobreNome());
                listaVip.putString("nomeCurso",pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
                listaVip.apply();
                */

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
       // Log.i("POO Adroid", "obj outrapessoa: " + outraPessoa.toString());

    }

    private class Curso {
    }
}