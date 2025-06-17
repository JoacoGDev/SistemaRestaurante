package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Item {

    private static int contadorId = 0;
    private int id;
    private String nombre;
    private double precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList();
    private UnidadProcesadora unidadProcesadora;

    public Item(String nombre, double precio, UnidadProcesadora unidadProcesadora) {
        id = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
        this.unidadProcesadora = unidadProcesadora;
    }
    
    //TEMPORAL
    public Item(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidadProcesadora = null;
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

    public boolean isDisponible() {
        for(Ingrediente i: ingredientes){
            if(!i.isDisponible()){
                return false;
            }
        }
        return true;
    }
    
    public void descontarStock() throws RestauranteException{
        
         for(Ingrediente i: ingredientes){
            if(i.isDisponible()){
               i.descontarStock();
            }
         }

    }

    @Override
    public String toString() {
        return nombre + " - " + precio;
    }

    public void reintegrarStock() {
        
          for(Ingrediente i: ingredientes){
            if(!i.isDisponible()){
               i.reintegrarStock();
            }
         }
    }

    public void agregarIngrediente(Ingrediente in) {
        this.ingredientes.add(in);
    }

    public boolean equals(Item o) {
        if (o == null){
            return false;
        }
        return this.nombre.equals(o.nombre);
    }

    void modificarStock() throws RestauranteException{
        for(Ingrediente i: ingredientes){
            i.descontarStock();
         }
    }

    void agregarPedidoUp(Pedido pedidoAAgregar) {
        this.unidadProcesadora.agregarPedido(pedidoAAgregar);
    }

    void borrarPedidoUp(Pedido p) {
        unidadProcesadora.borrarPedido(p);
    }

}
