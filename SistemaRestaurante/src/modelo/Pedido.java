package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Pedido extends Observable{
    
    public enum eventos {cambioPedido};
    
    private Item item;
    private String comentario;
    private EstadoPedido estado;
    private Gestor gestor;
    

    public Pedido(Item item, String comentario) {
        this.item = item;
        this.comentario = comentario;
        this.estado = EstadoPedido.NOCONFIRMADO;
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    public void confirmarPedido() throws RestauranteException{

        item.descontarStock();
        this.setEstado(EstadoPedido.CONFIRMADO);
     
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
        return this.getEstado() == EstadoPedido.NOCONFIRMADO;
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
