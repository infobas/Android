package devandroid.helio.appminhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {
    //DB incluir,listar, alterar,deletar
    //crud= create, retrieve, update, delete

    public boolean incluir(T obj);
    public boolean alterar(T obj);
    public boolean deletar(T obj);
    public List<T> listar();

}
