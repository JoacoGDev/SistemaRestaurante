package modelo;

import Controladores.ControladorUsuarios;
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

    public ArrayList<Pedido> getPedidos() throws RestauranteException{
        if(servicio == null){
            throw new RestauranteException("Debes iniciar sesión");
        }
            return servicio.getPedidos();
    }

    public void borrarPedido(int ind) throws RestauranteException{
        if(servicio == null){
            throw new RestauranteException("Debes iniciar seisón");
        }
        this.servicio.borrarPedido(ind);
    }

    public String confirmarServicio() throws RestauranteException {
        if(this.servicio == null){
            throw new RestauranteException("Debes iniciar sesión");
        }
        return this.servicio.confirmarServicio();
    }
    
    public void desvincularUsuario(){
        this.getCliente().desvincular();
        this.cliente = null;
        this.servicio = null;
    }

    public String finalizarServicio() throws RestauranteException{
        if(cliente == null || servicio == null){
            throw new RestauranteException("Debes iniciar sesión");
        }
        TipoCliente tc = this.cliente.getTipoCliente();
        String ret = this.servicio.calcularPrecio(tc);
        
        desvincularUsuario();
        return ret;
    }

    public void agregarObservador(ControladorUsuarios aThis) {
        servicio.agregarObservador(aThis);
    }


    public void quitarObservador(ControladorUsuarios aThis) {
        servicio.quitarObservador(aThis);
    }

}
