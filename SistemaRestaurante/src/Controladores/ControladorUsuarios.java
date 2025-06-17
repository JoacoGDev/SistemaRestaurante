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
import modelo.Servicio;
import observador.Observable;
import observador.Observador;

public class ControladorUsuarios implements Observador {

    //private VistaUsuario vistaLogin;
    private Fachada f = Fachada.getInstancia();
    private IVistaUsuario vUsuario;
    private Dispositivo dispUsu;


    public ControladorUsuarios(IVistaUsuario vistaUsuario){
        vUsuario = vistaUsuario;
        this.dispUsu = f.getDispositivo();
    }

    public void loginUsuario(String cliente, String password){
        try{
            if (cliente.isBlank() || cliente.isEmpty()){
                throw new RestauranteException("Credenciales invalidas");
            }
            int numeroCliente = Integer.parseInt(cliente);
            Cliente clienteLogueado = f.loginCliente(numeroCliente, password, dispUsu);
            dispUsu.agregarObservador(this);
            vUsuario.MostrarUsuario(clienteLogueado.getNombreCompleto());
            vUsuario.mostrarMensaje("Mensajes de Sistema");
         
        }catch(RestauranteException ex){
           vUsuario.mostrarMensaje(ex.getMessage());
        }
    }
    
    public void cargar(Cliente cli){
        cargarMenu();        
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
            if (dispUsu.getCliente() == null){
                throw new RestauranteException("Debes iniciar Sesión");
            }
            String totalServ = dispUsu.finalizarServicio();
            dispUsu.quitarObservador(this);    
            dispUsu.desvincularUsuario();
            vUsuario.mostrarConfirmar();
            vUsuario.mostrarMensaje(totalServ);
            vUsuario.cargarItems(new ArrayList<Item>());
            vUsuario.limpiarCampos();
            
        }catch(RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
        }
        
    }

    public void agregarPedidos(Item item, String comentario) {
        //itemSeleccionado es un String. Tengo que obtener el objeto item y agregarlo a un pedido
        try{
            Pedido pedidoAAgregar = f.agregarPedido(item, comentario, this.dispUsu);
        }catch(RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
        }
        
    
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
        }catch(RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
        }
         
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        try{
            if(evento.equals(Servicio.eventos.cambioListaPedidos)){
                vUsuario.actualizarTabla(dispUsu.getPedidos());
                vUsuario.actualizarMonto(dispUsu.getPrecio());
            }
            if(evento.equals(Servicio.eventos.cambioPedido)){
                vUsuario.actualizarTabla(dispUsu.getPedidos());
                vUsuario.actualizarMonto(dispUsu.getPrecio());
            }
        }
        catch (RestauranteException ex){
            vUsuario.mostrarMensaje(ex.getMessage());
        }
    }

}
