package modelo;

import java.util.ArrayList;
import modelo.Pedido.EstadoPedido;
import observador.Observable;
import observador.Observador;

public class Servicio extends Observable{

    

    public enum eventos{cambioListaPedidos, cambioPedido, pedidoParaEntregar};
    
    private ArrayList<Observador> observadores = new ArrayList();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private double montoTotal;
    private Dispositivo disp;
    

    public Servicio(Dispositivo disp) {
        montoTotal = 0;
        this.disp = disp;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
    
    public Cliente getCliente() {
        return disp.getCliente();
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public void modificarMontoTotal(double montoTotal) {
        this.montoTotal += montoTotal;
    }
    
    public Pedido agregarNuevoPedido(Item item, String comentario)throws RestauranteException{
        Pedido pedidoAAgregar = new Pedido(item, comentario, this);
        pedidoAAgregar.validar();
        this.pedidos.add(pedidoAAgregar);
        modificarMontoTotal(pedidoAAgregar.getPrecio());
        avisar(eventos.cambioListaPedidos);
        return pedidoAAgregar;
    }
    
    public void borrarPedido(int ind) throws RestauranteException {
        if (ind != -1) {
            Pedido p = pedidos.get(ind);
            borrarPedido(p);
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
        ArrayList<Pedido> filtrados = new ArrayList<Pedido>();
        boolean noConfirmados = false;
        int contador = 0;
        //noEstaEntregado  tieneNoConfirmados
        for (Pedido p : pedidos){
            if (!noConfirmados && p.tieneNoConfirmados()){
               noConfirmados = true;
            }
            if (p.noEstaEntregado()){
               contador++;
            }
            if (!p.noEstaEntregado()){
               filtrados.add(p);
            } 
        }
        String ret = "Factura: " + tc.descuento(filtrados);
        if(noConfirmados){
            ret += "\nTienes pedidos sin confirmar!";
        }
        if (contador >0){
            ret += "\n¡Tienes  "+ contador + " pedidos en proceso, recuerda ir a retirarlos!";
        }
        return ret;
    }
    
    public void borrarPedidos() {
        while(!pedidos.isEmpty()){
            int i = 0;
            Pedido p = pedidos.get(i);
            borrarPedido(p);
            i++;
        }
    }
    
    public void borrarPedido(Pedido p) {
        p.reintegrarStock();
        pedidos.remove(p);
        p.borrarPedidoUp();
        modificarMontoTotal(p.getPrecio() * -1);
        avisar(eventos.cambioListaPedidos);
    }
    
    public void cambioPedido() {
        avisar(eventos.cambioPedido);
    }
    
    public void pedidoParaEntregar() {
        avisar(eventos.pedidoParaEntregar);
    }
}
