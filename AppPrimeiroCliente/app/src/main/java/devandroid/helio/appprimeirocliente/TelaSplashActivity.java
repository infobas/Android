package devandroid.helio.appprimeirocliente;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaSplashActivity extends AppCompatActivity {
    String TAG = "App_Minha_Tarefa";
    int tempoDeEspera = 1000 * 15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        trocarTela();
    }

    private void trocarTela() {
        Log.d(TAG, "trocarTela: Mudando de Tela...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "trocarTela: Esperando Tela...");
                Intent trocarDeTela = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);
    }
}