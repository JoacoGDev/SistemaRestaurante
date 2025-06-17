package modelo;

import java.util.ArrayList;
import observador.Observable;

public class UnidadProcesadora extends Observable{

    

    public enum eventos{cambioListaPedidosUp};
    
    private String nombre;
    private ArrayList<Pedido> pedidos = new ArrayList();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    
    public void agregarPedido(Pedido p){
        pedidos.add(p);
        avisar(eventos.cambioListaPedidosUp);
    }
    
    void borrarPedido(Pedido p) {
        pedidos.remove(p);
        avisar(eventos.cambioListaPedidosUp);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
