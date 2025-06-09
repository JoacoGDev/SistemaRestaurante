package modelo;

import java.util.ArrayList;

public class Servicio {
    private ArrayList <Pedido> pedidos = new ArrayList<>();
    private double montoTotal;

    public Servicio() {
        montoTotal = 0;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public void agregarNuevoPedido(Pedido pedidoAAgregar){
        this.pedidos.add(pedidoAAgregar);
    }
    
    public void borrarPedido(int ind) throws RestauranteException {
        Pedido p = pedidos.get(ind);
        if(p.getEstado().equals(EstadoPedido.ENPROCESO)){
            throw new RestauranteException("Un poco tarde...Ya estamos elaborando este pedido");
        }
        p.reintegrarStock();
        pedidos.remove(ind);
        
    }

    public void confirmarServicio() throws RestauranteException {

        if (pedidos == null || pedidos.isEmpty()) {
            throw new RestauranteException("No hay pedidos nuevos.");
        }

        ArrayList<Pedido> pedidosNoDisponibles = new ArrayList<>();
        boolean hayConfirmaciones = false;

        for (Pedido p : pedidos) {
            if (p.getEstado().equals(EstadoPedido.NOCONFIRMADO)) {
                if (p.isDisponible()) {
                   
                    p.confirmarPedido();
                    hayConfirmaciones = true;
                } else {
                    pedidosNoDisponibles.add(p);
                }
            }
        }

        if (!pedidosNoDisponibles.isEmpty()) {
            StringBuilder mensaje = new StringBuilder("Nos hemos quedado sin stock de:\n");
            for (Pedido p : pedidosNoDisponibles) {
                mensaje.append("- ").append(p.getNombre()).append("\n");
                pedidos.remove(p);
            }
            throw new RestauranteException(mensaje.toString());
        }

        if (!hayConfirmaciones) {
            throw new RestauranteException("No se pudo confirmar ningún pedido.");
        }
        
        
    }

}
