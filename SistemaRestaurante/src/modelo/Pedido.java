package modelo;

import java.util.ArrayList;
import modelo.Estados.EstadoNoConfirmado;
import modelo.Estados.EstadoPedidos;
import observador.Observable;
import observador.Observador;

public class Pedido {
    
    public enum eventos {cambioPedido};
    
    public enum EstadoPedido {noConfirmado, confirmado, enProceso, finalizado, entregado};

    
    private Item item;
    private String comentario;
    private EstadoPedidos estado;
    private Gestor gestor;
    private Servicio servicio;
   
    public Pedido(Item item, String comentario) {
        this.item = item;
        this.comentario = comentario;
        this.estado = new EstadoNoConfirmado(this);
    }

    public EstadoPedido getEstado(){
        return estado.getEstado();
    }
    
    public Item getItems() {
        return item;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void confirmarPedido() throws RestauranteException{
        this.estado.confirmar();
    }

    public void procesarPedido() throws RestauranteException{
        this.estado.procesar();
    }
    
    public void finalizarPedido() throws RestauranteException{
        this.estado.finalizar();
    }
    
    public void entregarPedido() throws RestauranteException{
        this.estado.entregar();
    }
     
    public void cambiarEstado(EstadoPedidos estadoNuevo){
        this.estado = estadoNuevo;
    }
    
    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
        avisar(eventos.cambioPedido);
    }
    
    public double getPrecio(){
        return this.item.getPrecio();
    }
    
    public String getNombre(){
        return this.item.getNombre();
    }
    
    @Override
    public String toString() {
        return item.getNombre() + comentario;
}

    public boolean isDisponible() {
        return this.item.isDisponible();
    }


    public void reintegrarStock() {
        this.item.reintegrarStock();    
    }

    public void validar() throws RestauranteException{
        if(this.item == null){
            throw new RestauranteException("Debes seleccionar un Item");
        }
    }

    public boolean noConfirmado() {
        return this.estado.getEstado() == EstadoPedido.noConfirmado;
    }

    public void modificarStock() throws RestauranteException{
        item.modificarStock();
    }

    void agregarPedidoUp() {
        this.item.agregarPedidoUp(this);
    }

    public void borrarPedidoUp() {
        item.borrarPedidoUp(this);
    }
    
    
    
    
}
