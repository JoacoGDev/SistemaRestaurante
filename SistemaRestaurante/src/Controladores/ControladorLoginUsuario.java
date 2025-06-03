package Controladores;

import Vistas.VistaLogin;
import modelo.Dispositivo;
import modelo.Fachada;

import java.security.PrivateKey;

public class ControladorLoginUsuario {

    private VistaLogin vistaLogin;
    private Fachada fachada = Fachada.getInstancia();


    public ControladorLoginUsuario(VistaLogin vistaLogin){
        vistaLogin = vistaLogin;
    }

    public void loginUsuario(int numeroCliente, String password){

         Cliente clienteLogueado = fachada.loginCliente(numeroCliente, password);
         if(clienteLogueado != null){
             vistaLogin.mostrarNombreUsuario(clienteLogueado.getNombre());
         }

    }



}
