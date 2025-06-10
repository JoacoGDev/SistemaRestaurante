package modelo;

import java.util.ArrayList;

public abstract class TipoCliente {

    private String nombre;
    
    public TipoCliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public abstract String descuento(ArrayList<Pedido> pedidos);

   
    
    
    
}
