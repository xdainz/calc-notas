package models;

import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private ArrayList<Nota> notas;

    public Asignatura(String nombre, ArrayList<Nota> notas) {
        this.setNombre(nombre);
        this.setNotas(notas);
    }

    public Asignatura(String nombre){
        this.setNombre(nombre);
        notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void addNota(Nota nota){
        notas.add(nota);
    }

    public double getPromedio(){
        double acum = 0;
        for (Nota n : this.notas){
            acum += (n.getPonderacion() *0.01) * n.getNota();
        }
        return Utilidades.redondearNota(acum);
    }
}
