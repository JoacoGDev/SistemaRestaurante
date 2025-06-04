package inicio;

import Vistas.VistaDev;
import inicio.DatosPrueba;

public class Inicio {

    public static void main(String[] args) {
        VistaDev vd = new VistaDev();
        vd.setVisible(true);
        DatosPrueba.cargar();
    }
    
}
