package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Asignatura;
import modelo.Nota;
import modelo.Utilidades;
import visual.VisualVistaPrincipal;

public class ControladorVistaPrincipal {

    private VisualVistaPrincipal vista;

    public ControladorVistaPrincipal(VisualVistaPrincipal vista) {
        this.vista = vista;

    }

    public void inicializar() throws Exception {
        loadAsignaturas();
        vista.setVisible(true);
        loadNotas();

        vista.getCmbAsig().addItemListener((e) -> {
            if (e.getStateChange() == 2) {
                loadNotas();
            }
        });

        vista.getBtnAgregarNota().addActionListener((e) -> {
            try {
                agregarNotas();
            } catch (Exception ex) {
                Utilidades.error(ex.getMessage());
            }
        });

        vista.getBtnCalcNecesario().addActionListener((e) -> {
            try {
                calcNecesario();
            } catch (Exception ex) {
                Utilidades.error(ex.getMessage());
            }
        });

        vista.getBtnSave().addActionListener((e) -> {
            try {
                Utilidades.writeData();
                Utilidades.mostrarInfo("Se ha guardado con éxito.");
            } catch (IOException ex) {
                Utilidades.error(ex.getMessage());
            }
        });
    }

    private void loadAsignaturas() throws Exception {
        Utilidades.checkData();
        vista.cargarAsignaturas();

    }

    private void loadNotas() {
        String holder = vista.getCmbAsig().getSelectedItem().toString();

        for (Asignatura a : Utilidades.asignaturas) {
            if (a.getNombre().equals(holder)) {
                vista.cargarNotas(a);
                vista.cargarPromedio(a);
                break;
            }
        }
    }

    private void agregarNotas() throws Exception {
        String holder = vista.getCmbAsig().getSelectedItem().toString();
        int pond = Integer.parseInt(vista.getTxtPonderacion().getText());
        double nota = Double.parseDouble(vista.getTxtNota().getText());

        for (Asignatura a : Utilidades.asignaturas) {
            if (a.getNombre().equals(holder)) {
                a.addNota(new Nota(pond, nota));
                break;
            }
        }
        vista.limpiarAgregarNota();
        loadNotas();
    }

    private void calcNecesario() throws Exception {
        String holder = vista.getCmbAsig().getSelectedItem().toString();
        String pondRestante = "";
        String notaNecesaria = "";

        for (Asignatura a : Utilidades.asignaturas) {
            if (a.getNombre().equals(holder)) {
                pondRestante = String.valueOf((a.getPonderacionFaltante()));
                notaNecesaria = String.valueOf(a.getNotaAprobado());
                break;
            }
        }
        Utilidades.mostrarInfo("Se necesita un " + notaNecesaria + " en el " + pondRestante + "% restante.");
    }
}
