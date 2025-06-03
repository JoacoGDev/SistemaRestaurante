package modelo;

import java.util.ArrayList;

public class Item {

    private String nombre;
    private double precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList();
    private UnidadProcesadora unidadProcesadora;

    public Item(String nombre, double precio, UnidadProcesadora unidadProcesadora) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidadProcesadora = unidadProcesadora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }
}
