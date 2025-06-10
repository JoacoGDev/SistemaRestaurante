package modelo;

import java.util.ArrayList;

public class Dispositivo {
    private static int contadorId = 0;
    private int id;
    private Cliente cliente;
    private Servicio servicio;

    
    public Dispositivo() {
        this.id  = ++ contadorId;
        this.cliente = null;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
     public boolean isDisponible() {
        return cliente == null;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setServicio(Servicio servicio){ this.servicio = servicio;}



    public Servicio getServicio() {
        return servicio;
    }

    public Pedido agregarPedido(Item item, String comentario) throws RestauranteException {
        if (this.servicio == null) {
            throw new RestauranteException("Debes iniciar Sesión");
        }
        return this.servicio.agregarNuevoPedido(item, comentario);

    }

    public ArrayList<Pedido> getPedidos() {
        return servicio.getPedidos();
    }

    public void borrarPedido(int ind) throws RestauranteException{
        if(servicio == null){
            throw new RestauranteException("Debes iniciar seisón");
        }
        this.servicio.borrarPedido(ind);
    }

    public void confirmarServicio() throws RestauranteException {
        if(this.servicio == null){
            throw new RestauranteException("Debes iniciar sesión");
        }
        this.servicio.confirmarServicio();
    }

    public String finalizarServicio() {
        TipoCliente tc = this.cliente.getTipoCliente();
        String ret = this.servicio.calcularPrecio(tc);
        return ret;
    }
    
    
}
