package devandroid.helio.appminhaideiadb.datamodel;

public class ProdutoDataModel {

    //obs não criou a tabela produto
    public static final String TABELA = "produto";

    public static String ID = "id";
    public static String NOME = "nome";
    public static String FORNECEDOR = "fornecedor";

    public static String queryCriarTabela ="";

    //4-metodo gerar script para criar tabela
    public static String criarTabela(){
        //concatenação de string
        queryCriarTabela +="CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += FORNECEDOR+" text ";
        queryCriarTabela +=")";

        return queryCriarTabela;
    }


}
