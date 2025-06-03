package modelo;

import java.util.ArrayList;

public class UnidadProcesadora {

    private String nombre;
    private ArrayList<Gestor> gestores = new ArrayList();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }
}
