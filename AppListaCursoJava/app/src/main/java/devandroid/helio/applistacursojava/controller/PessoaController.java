package devandroid.helio.applistacursojava.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.helio.applistacursojava.database.ListaVipDB;
import devandroid.helio.applistacursojava.model.Pessoa;
import devandroid.helio.applistacursojava.view.MainActivity;

public class PessoaController  extends ListaVipDB {


    SharedPreferences preferences;
    SharedPreferences.Editor listaVip; //necessario para criar limpar e consultar
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){  //instancia
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        //adicionado v3
        listaVip = preferences.edit();

    }



    public void salvar(Pessoa pessoa) {
        ContentValues dados = new ContentValues();

        Log.d("MVC_Controller", "Salvo Pessoa: "+pessoa.toString());
        //adicionado v3
        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobreNome", pessoa.getSobreNome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());

        salvarObjeto("Pessoa",dados);

    }

    public Pessoa buscarDadosSharedPreferences(Pessoa pessoa){
        //adicionado v3
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));
    return pessoa;
    }

    public void alterar(Pessoa pessoa){

        ContentValues dados = new ContentValues();

        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobreNome", pessoa.getSobreNome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());


        alterarObjeto("Pessoa",dados);

    }

    public void deletar(int id){
        deletarObjeto("Pessoa",id);
    }

    public void limpar(){
        //adicionado v3
        listaVip.clear();
        listaVip.apply();

    }
}
