package devandroid.helio.applistacursojava.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.helio.applistacursojava.R;
import devandroid.helio.applistacursojava.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa; //objeto é um tipo de dado
    Pessoa outraPessoa; //objeto é usado para sets

    String dadosPessoa; //pascal case e camel case
    String dadosOutraPessoa; // gets



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

        pessoa = new Pessoa();
        //atribuir dados ao objeto conforme modelo template
        pessoa.setPrimeiroNome("Helio");
        pessoa.setSobreNome("Basilone Paiva");
        pessoa.setCursoDesejado("Analise em Android");
        pessoa.setTelefoneContato("19 9911224455");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Marcelo");
        outraPessoa.setSobreNome("Cabelo de Buneca");
        outraPessoa.setCursoDesejado("Analise em Android");
        outraPessoa.setTelefoneContato("19 9911224466");


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


    }
}