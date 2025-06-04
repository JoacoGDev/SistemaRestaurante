package Controladores;

import Vistas.VistaUsuario;
import modelo.Dispositivo;
import modelo.Fachada;

import java.security.PrivateKey;
import modelo.Cliente;

public class ControladorUsuarios {

    //private VistaUsuario vistaLogin;
    private Fachada fachada = Fachada.getInstancia();


    public ControladorUsuarios(VistaUsuario vistaUsuario){
        vistaUsuario = vistaUsuario;
    }

    public void loginUsuario(int numeroCliente, String password){

         Cliente clienteLogueado = fachada.loginCliente(numeroCliente, password);
         if(clienteLogueado != null){
             
         }
    }
    
    public void cargarCategorias(){
        
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
