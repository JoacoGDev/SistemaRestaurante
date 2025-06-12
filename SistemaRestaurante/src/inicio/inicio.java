package inicio;

import Vistas.VistaInicio;
import inicio.DatosPrueba;

public class inicio {

    public static void main(String[] args) {
        VistaInicio vi = new VistaInicio();
        vi.setVisible(true);
        DatosPrueba.cargar();
    }
    
}
