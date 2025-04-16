package devandroid.helio.applistacursojava.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.helio.applistacursojava.model.Pessoa;
import devandroid.helio.applistacursojava.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip; //necessario para criar limpar e consultar
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){  //instancia
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        //adicionado v3
        listaVip = preferences.edit();

    }


    //comando @ toString código auto
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }


    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo Pessoa: "+pessoa.toString());
        //adicionado v3
        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("nomeCurso",pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply();

    }

    public Pessoa buscar(Pessoa pessoa){
        //adicionado v3
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));
    return pessoa;
    }

    public void limpar(){
        //adicionado v3
        listaVip.clear();
        listaVip.apply();

    }
}
