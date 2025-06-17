package modelo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import modelo.Estados.EstadoNoConfirmado;
import modelo.Estados.EstadoPedidos;

public class Pedido {

    
    
    public enum EstadoPedido {noConfirmado, confirmado, enProceso, finalizado, entregado};

    private String fecha = fechaAhora();
    private Item item;
    private String comentario;
    private EstadoPedidos estado;
    private Gestor gestor;
    private Servicio servicio;
   
    public Pedido(Item item, String comentario, Servicio ser) {
        this.item = item;
        this.comentario = comentario;
        this.estado = new EstadoNoConfirmado(this);
        servicio = ser;
    }

    public EstadoPedido getEstado(){
        return estado.getEstado();
    }
    
    public Item getItems() {
        return item;
    }

    public String getFecha() {
        return fecha;
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
        borrarPedidoUp();
    }
    
    public void finalizarPedido() throws RestauranteException{
        this.estado.finalizar();
    }
    
    public void entregarPedido() throws RestauranteException{
        this.estado.entregar();
    }
     
    public void cambiarEstado(EstadoPedidos estadoNuevo){
        this.estado = estadoNuevo;
        this.servicio.cambioPedido();
    }
    
    public Gestor getGestor() {
        return gestor;
    }
    
    public Cliente getCliente(){
        return servicio.getCliente();
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
        this.servicio.cambioPedido();
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
    
    public String getNombrePedido(){
        return estado.getNombre();
    }
    
    public String fechaAhora() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return ahora.format(myFormatObj);
    }
    
    public boolean filtrarACobrar() {
        if (this.getEstado() == EstadoPedido.noConfirmado || this.getEstado() == EstadoPedido.confirmado){
            return false;
        }
        return true;
    }
    
    
}
