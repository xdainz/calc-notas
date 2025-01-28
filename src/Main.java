import controlador.ControladorVistaPrincipal;
import modelo.Utilidades;
import visual.VisualVistaPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
            ControladorVistaPrincipal cvp = new ControladorVistaPrincipal(new VisualVistaPrincipal());

            cvp.inicializar();
        } catch (Exception ex) {
            Utilidades.error(ex.getMessage());
        }
    }
    }