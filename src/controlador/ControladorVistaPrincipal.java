package controlador;

import modelo.Asignatura;
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
            }
        }
    }
}
