package devandroid.helio.applistacursojava.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.helio.applistacursojava.model.Curso;

public class CursoController {


    private List listCursos;


    public List getListaCursos(){
        listCursos = new ArrayList<Curso>();


        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("Arduino"));
        listCursos.add(new Curso("VB Studio"));
        listCursos.add(new Curso("CCS Compiler"));
        listCursos.add(new Curso("Assembler"));

        return listCursos;

    }

    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCursos().size(); i++) {

            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());

        }
        return dados;

    }


}
