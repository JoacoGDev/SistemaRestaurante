package Controladores;

import Vistas.VistaUsuario;
import modelo.Dispositivo;
import modelo.Fachada;

import java.security.PrivateKey;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Categoria;
import modelo.Item;
import modelo.Menu;
import modelo.Pedido;
import modelo.RestauranteException;

public class ControladorUsuarios {

    //private VistaUsuario vistaLogin;
    private Fachada f = Fachada.getInstancia();
    private IVistaUsuario vUsuario;
    private Dispositivo dispUsu;


    public ControladorUsuarios(IVistaUsuario vistaUsuario){
        vUsuario = vistaUsuario;
        this.dispUsu = f.getDispositivo();
    }

    public void loginUsuario(int numeroCliente, String password){
        try{
            Cliente clienteLogueado = f.loginCliente(numeroCliente, password, dispUsu);
            vUsuario.MostrarUsuario(clienteLogueado.getNombreCompleto());
            vUsuario.mostrarMensaje("Mensajes de Sistema");
            cargarCategorias();
         
        }catch(RestauranteException ex){
           vUsuario.mostrarMensaje(ex.getMessage());
        }
    }
    
    public void cargar(Cliente cli){
        actualizarNombre();
        cargarMenu();
        
    }
    
    private void actualizarNombre() {
        
    }

    private void cargarMenu() {
        cargarCategorias();
    }
    
    public void cargarCategorias(){
        ArrayList<Categoria> categorias = f.getCategoria();
        vUsuario.cargarCategorias(categorias);
        
    }
    
    public void cargarItems(Categoria cat){
        ArrayList<Item> items = f.getItems(cat);
        vUsuario.cargarItems(items);
    }
    
    public void eliminarPedidos(){
        
    }
    
    public void confirmarPedidos(){
        
    }
    
    public void finalizarServicio(){
        
    }

    public void agregarPedidos(Item item, String comentario) throws RestauranteException{
        //itemSeleccionado es un String. Tengo que obtener el objeto item y agregarlo a un pedido
        if(item != null){
            Pedido pedidoAAgregar = new Pedido(item, comentario);
            f.agregarPedido(pedidoAAgregar, this.dispUsu);
            cargarPedidos(pedidoAAgregar);
        }else{
            throw new RestauranteException("Debes Seleccionar un Item");
        }
  
        
    }
    
    public void cargarPedidos(Pedido pedidoAAgregar){
        
        vUsuario.cargarPedido(pedidoAAgregar);
    }

    public void borrarPedido(int ind) throws RestauranteException{
        if (ind == -1){
            throw new RestauranteException("Seleccione un pedido para eliminarlo");
        }
        dispUsu.borrarPedido(ind);
    }

    public void confirmarServicio() throws RestauranteException {
        dispUsu.confirmarServicio();
        vUsuario.actualizarTabla(dispUsu.getPedidos());
    }

}
