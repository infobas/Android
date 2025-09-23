package devandroid.helio.appminhaideiadb.datamodel;

public class ClienteDataModel {

    //1-atributo nome da tabela
    public static final String TABELA = "cliente";


    //2-atributo para cada nome dos campos
    public static final String ID = "id"; //integer no sqllite
    public static final String NOME = "nome";//text
    public static final String EMAIL = "email";//text


    //3-query criar tabela no BD
    public static String queryCriarTabela ="";

    //4-metodo gerar script para criar tabela
    public static String criarTabela(){
        //concatenação de string
        queryCriarTabela +="CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += EMAIL+" text ";
        queryCriarTabela +=")";

        return queryCriarTabela;
    }

    //5-query consulta gerais
}
