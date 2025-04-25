package devandroid.helio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Tipos de dados Primitivos - int, float, long, double
    // Tipos de dados não Primitivos "Classes"- Integer, Float, Long, Double

    List<Float> precos;
    List<Double> valores;
   // List<Cliente> clientes;
    List<Cliente> clientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precos = new ArrayList<>();
        clientes = new ArrayList<>();

        precos.add(10.00f); // 0
        precos.add(20f); // 1
        precos.add(30f); // 2
        precos.add(40f); // 3
        precos.add(50.8237812372f); // 4
        precos.add(60f); // 5
        precos.add(70f); // 6

        Cliente objA = new Cliente();
        objA.setId(1);
        objA.setNome("Maddo");
        objA.setEmail("maddo@teste.com");
        objA.setPreco(12.34567f);

        Cliente objB = new Cliente();
        objB.setId(2);
        objB.setNome("Maddo B");
        objB.setEmail("maddo_b@teste.com");
        objB.setPreco(23.45678f);

        clientes.add(objA);
        clientes.add(objB);

/*
        for (int i = 0; i < inteiros.size(); i++) {

            Log.i("Inteiros", "For I Elemento: "+i+" - "+inteiros.get(i));

        }


        for (Integer numero: inteiros) {

            Log.i("Inteiros", "For Each Elemento: "+numero);

        }*/

       /* for (Float preco: precos) {

            Log.i("Inteiros", "For Each Elemento: "+preco);

        }*/


        for (Cliente obj: clientes) {

            Log.e("Clientes", "*****");
            Log.i("Clientes", "id: "+obj.getId());
            Log.i("Clientes", "nome: "+obj.getNome());
            Log.i("Clientes", "email: "+obj.getEmail());
            Log.i("Clientes", "preço: "+obj.getPreco());



        }


    }
}