/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelo.Fachada;
import modelo.Gestor;
import modelo.RestauranteException;

/**
 *
 * @author joaco
 */
public class ControladorLoginGestor {

    private Fachada f = Fachada.getInstancia();
    private IVistaLoginGestor vLoginGestor;
    

    public ControladorLoginGestor(IVistaLoginGestor vLoginGestor) {
        this.vLoginGestor = vLoginGestor;
    }
    

    public void loginGestor(String usuario, String pass) {
     try{
           f.loginGestor(usuario, pass);
           vLoginGestor.mostrarVistaGestor();
     }catch(RestauranteException ex){
            vLoginGestor.mostrarMensaje(ex.getMessage());
     }
    }
    
    
    
//    
//        private Fachada f = Fachada.getInstancia();
//    private IVistaUsuario vUsuario;
//    private Dispositivo dispUsu;
//
//
//    public ControladorUsuarios(IVistaUsuario vistaUsuario){
//        vUsuario = vistaUsuario;
//        this.dispUsu = f.getDispositivo();
//    }
}
