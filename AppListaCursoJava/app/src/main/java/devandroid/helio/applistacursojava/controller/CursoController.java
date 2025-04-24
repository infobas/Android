package devandroid.helio.applistacursojava.controller;

import java.util.ArrayList;
import java.util.List;

public class CursoDesejadoControl {


    private List listCursos;

    private List listCursos() {

    }

    public List getListaCursos(){
        listCursos() = new ArrayList<Curso>();


        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("Arduino"));
        listCursos.add(new Curso("VB Studio"));
        listCursos.add(new Curso("CCS Compiler"));
        listCursos.add(new Curso("Assembler"));

        return listCursos;

    }
}
