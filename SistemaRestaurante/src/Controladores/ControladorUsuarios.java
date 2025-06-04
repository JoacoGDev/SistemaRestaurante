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


    public ControladorUsuarios(VistaUsuario vistaUsuario){
        vistaUsuario = vistaUsuario;
    }

    public void loginUsuario(int numeroCliente, String password){
        try{
            Cliente clienteLogueado = fachada.loginCliente(numeroCliente, password);
         
        }catch(RestauranteException ex){
            
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
