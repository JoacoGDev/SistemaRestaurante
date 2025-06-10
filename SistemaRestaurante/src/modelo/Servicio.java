package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Servicio extends Observable{

    
    
    public enum eventos{cambioListaPedidos};
    
    private ArrayList<Pedido> pedidos = new ArrayList<>();
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
    
    public Pedido agregarNuevoPedido(Item item, String comentario)throws RestauranteException{
        Pedido pedidoAAgregar = new Pedido(item, comentario);
        pedidoAAgregar.validar();
        this.pedidos.add(pedidoAAgregar);
        avisar(eventos.cambioListaPedidos);
        return pedidoAAgregar;
    }
    
    public void borrarPedido(int ind) throws RestauranteException {
        if (ind != -1) {
            Pedido p = pedidos.get(ind);
            if (p.getEstado().equals(EstadoPedido.ENPROCESO)) {
                throw new RestauranteException("Un poco tarde...Ya estamos elaborando este pedido");
            }
            p.reintegrarStock();
            pedidos.remove(ind);
        }else{
            throw new RestauranteException("Debes seleccionar un pedido");
        }

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
    
    public String calcularPrecio(TipoCliente tc) {
        return tc.descuento(pedidos);
    }

}
