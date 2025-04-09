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


    Pessoa pessoa;

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

        int parada = 0; //criando ponto de interrupção


    }
}