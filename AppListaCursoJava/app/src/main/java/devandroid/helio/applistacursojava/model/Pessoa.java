package devandroid.helio.applistacursojava.model;

public class Pessoa {

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    //construtor
    //atributos - objetos - molde - modelo - template
    //metodos de acesso gets and sets
    // f na estrutura são propriedades
    private String primeiroNome; // atributos
    private String sobreNome;
    private String cursoDesejado;
    private String telefoneContato;


    public Pessoa(){}
}
