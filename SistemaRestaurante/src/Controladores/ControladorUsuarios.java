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
    
    public void cargarItems(String nom) {
        ArrayList<Item> items = f.getItems(nom);
        vUsuario.cargarItems(items);
    }
    
    
    public void finalizarServicio(){
        try{
            
            String totalServ = dispUsu.finalizarServicio();
            vUsuario.mostrarConfirmar();
            vUsuario.mostrarMensaje(totalServ);
        }catch(RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
        }
        
    }

    public void agregarPedidos(Item item, String comentario) {
        //itemSeleccionado es un String. Tengo que obtener el objeto item y agregarlo a un pedido
        try{
            Pedido pedidoAAgregar = f.agregarPedido(item, comentario, this.dispUsu);
            cargarPedidos(pedidoAAgregar);
        }catch(RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
        }
        
    
    }
    
    public void cargarPedidos(Pedido pedidoAAgregar){
     
        vUsuario.cargarPedido(pedidoAAgregar);
    }

    public void borrarPedido(int ind){
       try{
        if (ind == -1){
            throw new RestauranteException("Seleccione un pedido para eliminarlo");
        }
        dispUsu.borrarPedido(ind);
       }catch (RestauranteException ex){
           vUsuario.mostrarMensaje(ex.getMessage());
       }
    }

    public void confirmarServicio() {
        
        try{
            vUsuario.mostrarMensaje(dispUsu.confirmarServicio());
            vUsuario.actualizarTabla(dispUsu.getPedidos());
        }catch(RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
            try{
                vUsuario.actualizarTabla(dispUsu.getPedidos());
            }catch(RestauranteException ex2){
                vUsuario.mostrarMensaje(ex2.getMessage());
            }

        }
         
    }

}
