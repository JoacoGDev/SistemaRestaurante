package Controladores;

import Vistas.VistaUsuario;
import modelo.Dispositivo;
import modelo.Fachada;

import java.security.PrivateKey;
import modelo.Cliente;
import modelo.Menu;
import modelo.RestauranteException;

public class ControladorUsuarios {

    //private VistaUsuario vistaLogin;
    private Fachada fachada = Fachada.getInstancia();
    private IVistaUsuario vUsuario;


    public ControladorUsuarios(IVistaUsuario vistaUsuario){
        vUsuario = vistaUsuario;
    }

    public void loginUsuario(int numeroCliente, String password){
        try{
            Cliente clienteLogueado = fachada.loginCliente(numeroCliente, password);
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
        fachada.getMenu().getCategorias();
    }
    
    public void cargarItems(){
        
    }
    
    public void agregarPedidos(){
        
    }
    
    public void eliminarPedidos(){
        
    }
    
    public void confirmarPedidos(){
        
    }
    
    public void finalizarServicio(){
        
    }

    

}
