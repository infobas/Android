package devandroid.helio.appminhaideiadb.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.helio.appminhaideiadb.R;
import devandroid.helio.appminhaideiadb.api.AppUtil;
import devandroid.helio.appminhaideiadb.controller.ClienteController;
import devandroid.helio.appminhaideiadb.controller.ProdutoController;
import devandroid.helio.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;

    ProdutoController produtoController;


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
        Log.d(AppUtil.TAG, "onCreate: AppMinhaIdeiaDB ");

        clienteController = new ClienteController(getApplicationContext());
        produtoController = new ProdutoController(getApplicationContext());
        /*
        for (int i = 0; i < 49; i++) {
            obj = new Cliente();
            //obj.setId(1); //para deletar e para alterar
            obj.setNome("Eber Cochão"+i);
            obj.setEmail(i+"cochao@terra.com.br");
            clienteController.incluir(obj);

        }*/




/*
        objN = new Cliente();
        objN.setNome("Marcelo Cabelo"); // incluir
        objN.setEmail("cabelo@terra.com.br");


        if(clienteController.incluir(obj)) {
            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente: " + obj.getNome() + " incluido com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " não incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente: " + obj.getNome() + " não incluido com sucesso!");

        }
        if(clienteController.incluir(objN)) {
            Toast.makeText(MainActivity.this, "Cliente: " + objN.getNome() + " incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente: " + objN.getNome() + " incluido com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente: " + objN.getNome() + " não incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente: " + objN.getNome() + " não incluido com sucesso!");

        }
        if(clienteController.deletar(obj.getId())) {
            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " excluido com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente: " + obj.getNome() + " exluido com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " não excluido com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente: " + obj.getNome() + " não excluido com sucesso!");

        }
        if(clienteController.alterar(obj)) {
            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " alterado com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente: " + obj.getNome() + " alterado com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " não alterado com sucesso!",
                    Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente: " + obj.getNome() + " não alterado com sucesso!");

        }
        for (int i = 0; i <49; i++) {
            obj=new Cliente();
            obj.setNome("Bolao"+i);
            obj.setEmail(i+"bolao@bolao.com.br");
            clienteController.incluir(obj);
        }*/
        //clienteController.listar();
        for (Cliente obj: clienteController.listar()) {
            Log.e("Retorno", "onCreate: "+obj.getId()+" "+obj.getNome()+" "+obj.getEmail());
            
        }


    }

}