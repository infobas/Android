package devandroid.helio.appminhaideiadb.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.helio.appminhaideiadb.api.AppUtil;
import devandroid.helio.appminhaideiadb.datamodel.ClienteDataModel;
import devandroid.helio.appminhaideiadb.datamodel.ProdutoDataModel;
import devandroid.helio.appminhaideiadb.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME ="AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG, "AppDataBase: Criando BD ");

        db =getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Cli Criada "+ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Pro Criada "+ProdutoDataModel.criarTabela());
        //db.execSQL(ClienteDataModel.criarTabela());
        //Log.d(AppUtil.TAG, "onCreate: Criada tabela cliente "+ClienteDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    /**
     * Metodo para inclusão DB
     * @return
     */
    public boolean insert(String tabela, ContentValues dados){

        db =getWritableDatabase();
        boolean retorno = false;
        //regra de negocio
        //try é um tratador de erro
        try{  //tipo se der certo
            retorno = db.insert(tabela,null,dados) > 0;
        } catch (Exception e){ //se não der certo
            Log.d(AppUtil.TAG, "insert: "+e.getMessage());
        }
        return retorno;
        //ou return = db.insert(tabela,null,dados) > 0; remove codigo acima
    }

    public boolean deleteByID(String tabela, int id){

        db =getWritableDatabase();
        boolean retorno = false;
        //regra de negocio
        //try é um tratador de erro
        try{  //tipo se der certo
            //retorno = db.insert(tabela,null,dados) > 0;
            retorno = db.delete(tabela,"id = ?",new String[] {String.valueOf(id)}) > 0;
        } catch (Exception e){ //se não der certo
            Log.d(AppUtil.TAG, "delete: "+e.getMessage());
        }
        return retorno;
        //ou return = db.insert(tabela,null,dados) > 0; remove codigo acima
    }

    public boolean update(String tabela, ContentValues dados){

        db =getWritableDatabase();
        boolean retorno = false;
        //regra de negocio
        //try é um tratador de erro
        try{  //tipo se der certo
            retorno = db.update(tabela,dados,"id=?",new String[] {String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e){ //se não der certo
            Log.d(AppUtil.TAG, "update: "+e.getMessage());
        }
        return retorno;
        //ou return = db.insert(tabela,null,dados) > 0; remove codigo acima
    }

    public List<Cliente> getAllClientes(String tabela){
        //this.tabela = tabela;
        db = getReadableDatabase(); //apenas leitura
        //db = getWritableDatabase(); //escrita e leitura

        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;
        String sql ="SELECT * FROM " + tabela;
        Cursor cursor; //devolve conteudo do select
        cursor = db.rawQuery(sql,null);

        //cursor.moveToFirst();
        if(cursor.moveToFirst()){
            do{
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                clientes.add(obj);

                Log.i("Listar", "getAllClientes: "+obj.getNome());

            }while (cursor.moveToNext());
        }
        return clientes;
    }

}
