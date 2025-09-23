package devandroid.helio.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import devandroid.helio.appminhaideiadb.datamodel.ProdutoDataModel;
import devandroid.helio.appminhaideiadb.datasource.AppDataBase;
import devandroid.helio.appminhaideiadb.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;
    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {
        dadoDoObjeto = new ContentValues();
        //dadoDoObjeto.put(ProdutoDataModel.ID,obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR,obj.getFornecedor());
       /*
        //dadoDoObjeto.put("id",obj.getId());
        dadoDoObjeto.put("nome",obj.getNome());
        dadoDoObjeto.put("fornecedor",obj.getFornecedor());*/
        return insert(ProdutoDataModel.TABELA,dadoDoObjeto);
    }

    @Override
    public boolean alterar(Produto obj) {
        dadoDoObjeto = new ContentValues();
        dadoDoObjeto.put(ProdutoDataModel.ID,obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR,obj.getFornecedor());
        /*
        dadoDoObjeto.put("id",obj.getId());
        dadoDoObjeto.put("nome",obj.getNome());
        dadoDoObjeto.put("fornecedor",obj.getFornecedor());*/
        return false;
    }

    @Override
    public boolean deletar(int id) {


        //dadoDoObjeto.put("id",obj.getId());
        return false;
    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        return lista;
    }
}
