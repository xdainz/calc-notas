import models.Asignatura;
import models.Nota;

public class Main {
    public static void main(String[] args) {
        try {
            Asignatura a1 = new Asignatura("Bases de datos 1");
            a1.addNota(new Nota(30, 5.3));
            a1.addNota(new Nota(40, 2.8));
            a1.addNota(new Nota(30, 6.7));
            System.out.println(a1.getNotas());
            System.out.println(a1.getPromedio());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}