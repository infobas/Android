package devandroid.helio.appminhaideiadb.controller;

import static android.provider.SyncStateContract.Helpers.update;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.helio.appminhaideiadb.api.AppUtil;
import devandroid.helio.appminhaideiadb.datamodel.ClienteDataModel;
import devandroid.helio.appminhaideiadb.datasource.AppDataBase;
import devandroid.helio.appminhaideiadb.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);
        Log.d(AppUtil.TAG, "ClienteController: Conectado");

    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        //dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        return insert(ClienteDataModel.TABELA,dadoDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        return update(ClienteDataModel.TABELA,dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {
        return deleteByID(ClienteDataModel.TABELA,id);
    }

    @Override
    public List<Cliente> listar() {

        /*
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());


        Cliente novo = new Cliente();
        novo.setId(6);
        novo.setNome("Roger Par");
        novo.setEmail("rog.spt.com.br");
        lista.add(novo);

        int totalClientes = lista.size();*/

        return getAllClientes(ClienteDataModel.TABELA);
        //return lista;
        //return null;
    }

    public boolean verificaPagamentoEmDia(){

        //regra de negócio

        return true;
    }

}
