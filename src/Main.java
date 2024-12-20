import models.Asignatura;
import models.Nota;
import models.Utilidades;

import static models.Utilidades.asignaturas;

public class Main {
    public static void main(String[] args) {
        try {
            Utilidades.checkData();

//            Asignatura a1 = new Asignatura("Java");
//            Asignatura a2 = new Asignatura("BD");
//
//            a1.addNota(new Nota(30, 4.0));
//            a2.addNota(new Nota(30, 2.0));
//            a2.addNota(new Nota(40, 1.5));
//
//            asignaturas.add(a1);
//            asignaturas.add(a2);
            System.out.println(asignaturas);
            Utilidades.writeData();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    }