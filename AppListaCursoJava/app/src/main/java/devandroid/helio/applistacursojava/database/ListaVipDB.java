package devandroid.helio.applistacursojava.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.helio.appgaseta.model.Combustivel;

public class GasEtaDB extends SQLiteOpenHelper {
    //i2
    private static final String DB_NAME = "listavip.db";
    private static final int DB_VERSION = 1;

    //f2
    //i4
    Cursor cursor;
    SQLiteDatabase db;
    //f4

    //i3
    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        //i5
        db = getWritableDatabase(); //escrita e leitura
        //f5
    }
    //f3
    //criar metodos para CRUD Create Retrieve Update Delete DB(SQL)
    //i1
    @Override
    public void onCreate(SQLiteDatabase db) {
        //i6
        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        String sqlTabelaVeiculo
                = "CREATE TABLE Veiculo (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCarro TEXT, " +
                "placaDoCarro TEXT)";

        db.execSQL(sqlTabelaCombustivel);
        db.execSQL(sqlTabelaVeiculo);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //f1
    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);

    }

    public List<Combustivel> listarDados(){

        List<Combustivel> lista = new ArrayList<>();
        Combustivel registro;
        String querySQL = "SELECT * from Combustivel";
        cursor = db.rawQuery(querySQL,null);
        if (cursor.moveToFirst()){
            do{
                registro = new Combustivel();
                registro.setId(cursor.getInt(0));
                registro.setNomeDoCombustivel(cursor.getString(1));
                registro.setPrecoDoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);

            } while (cursor.moveToNext());

        }else{

        }
        return lista;

    }

    public void alterarObjeto(String tabela, ContentValues dados){
        int id = dados.getAsInteger("id");

        db.update(tabela,dados,"id=?",
                new String[]{Integer.toString(id)});


    }

    public void deletarObjeto(String tabela, int id){


        db.delete(tabela,"id=?",
                new String[]{Integer.toString(id)});


    }

}
