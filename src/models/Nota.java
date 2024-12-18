package models;

public class Nota {
    private int ponderacion;
    private double nota;

    public Nota(int ponderacion, double nota) throws Exception {
        this.setPonderacion(ponderacion);
        this.setNota(nota);
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) throws Exception {
        if (1 <= ponderacion && ponderacion <= 100) {
            this.ponderacion = ponderacion;
        } else {
            throw new Exception("Ponderacion invalida");
        }
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) throws Exception {
        if (1 <= nota && nota <= 7) {
            this.nota = nota;
        } else {
            throw new Exception("Nota invalida");
        }
    }

    @Override
    public String toString() {
        return this.getPonderacion()+ "% " + this.getNota();
    }
}
