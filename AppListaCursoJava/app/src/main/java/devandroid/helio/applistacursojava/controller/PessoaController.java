package devandroid.helio.applistacursojava.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.helio.applistacursojava.model.Pessoa;

public class PessoaController {
    //comando @ toString código auto
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo Pessoa: "+pessoa.toString());

    }
}
