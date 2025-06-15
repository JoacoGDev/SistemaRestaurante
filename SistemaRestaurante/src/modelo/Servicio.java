package modelo;

import java.util.ArrayList;
import modelo.Pedido.EstadoPedido;
import observador.Observable;
import observador.Observador;

public class Servicio extends Observable{
    
    public enum eventos{cambioListaPedidos};
    
    private ArrayList<Observador> observadores = new ArrayList();
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
            if (p.getEstado().equals(EstadoPedido.enProceso)) {
                throw new RestauranteException("Un poco tarde...Ya estamos elaborando este pedido");
            }
            if(p.getEstado().equals(EstadoPedido.finalizado))  {
                throw new RestauranteException("El pedido ya está finalizado");
            }
            if(p.getEstado().equals(EstadoPedido.entregado))  {
                throw new RestauranteException("El pedido ya está entregado");
            }
            p.reintegrarStock();
            pedidos.remove(ind);
            p.borrarPedidoUp();
            avisar(eventos.cambioListaPedidos);
        }else{
            throw new RestauranteException("Debes seleccionar un pedido");
        }

    }

    public String confirmarServicio() throws RestauranteException {
        if (pedidos == null || pedidos.isEmpty()) {
            throw new RestauranteException("No hay pedidos ingresados.");
        }
        String ret = "";
        ArrayList<Pedido> aConfirmar = new ArrayList<>();
        ArrayList<Pedido> sinStock = new ArrayList<>();
        for(Pedido p: pedidos){
            if (p.noConfirmado()){
                aConfirmar.add(p);
            }
        }
        
        if(aConfirmar.isEmpty()){
            throw new RestauranteException("No hay pedidos nuevos");
        }
        
        for(Pedido p : aConfirmar){
            if(p.isDisponible()){
                    p.confirmarPedido();
                    p.modificarStock();
                    p.agregarPedidoUp();
                }
                else{
                    sinStock.add(p);
                }
        }
        
        if (!sinStock.isEmpty()){
            ret = "No tenemos stock para los siguientes items";
            for (Pedido p : sinStock){
                ret += " - " + p.getNombre();
                pedidos.remove(p);
            }
            ret += " - y no pudimos avisarte antes!";
        }
        
        avisar(eventos.cambioListaPedidos);
        return ret;
    }
    
    public String calcularPrecio(TipoCliente tc) {
        return tc.descuento(pedidos);
    }
    
    

}
