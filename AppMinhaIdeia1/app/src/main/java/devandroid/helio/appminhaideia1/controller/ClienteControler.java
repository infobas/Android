package devandroid.helio.appminhaideia1.controller;

import android.util.Log;

import devandroid.helio.appminhaideia1.core.AppUtil;

public class ClienteControler {

    String versaoApp;
    public ClienteControler(){
        this.versaoApp = AppUtil.versaoDoAplicativo();

        Log.i(AppUtil.TAG, "ClienteControler Versao do App: "+versaoApp);

    }
}
