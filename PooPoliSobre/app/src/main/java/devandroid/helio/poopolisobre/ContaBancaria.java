package devandroid.helio.poopolisobre;

import android.util.Log;

public class ContaBancaria {
    public ContaBancaria(){

        Log.v("Polimorfismo", "Conta Bancaria Aberta");
        Log.v("Polimorfismo", "Sem Deposito");
    }
    public ContaBancaria(double deposito){
        Log.v("Polimorfismo","Conta Salário Aberta");
        Log.v("Polimorfismo","Depositado R$ "+deposito);

    }
    public ContaBancaria(double deposito, double poupanca){
        Log.v("Polimorfismo","Conta Bancaria Aberta");
        Log.v("Polimorfismo","Depositado na Conta R$ "+deposito);
        Log.v("Polimorfismo","Depositado na Poupança R$ "+poupanca);

    }
}
