package modelo;

import java.util.ArrayList;

public class CComun extends TipoCliente {

    public CComun() {
        super("Comun");
    }

    @Override
    public String descuento(ArrayList<Pedido> pedidos) {
        double total = 0;
        for (Pedido p : pedidos){
            total += p.getPrecio();
        }        
        return String.valueOf(total);
    }
}
