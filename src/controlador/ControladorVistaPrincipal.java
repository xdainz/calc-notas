package controlador;

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
}
