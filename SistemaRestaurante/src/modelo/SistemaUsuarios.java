/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;


public class SistemaUsuarios {
    
    public ArrayList<Cliente> clientes = new ArrayList();
    public ArrayList<Gestor> gestores = new ArrayList();


    public void agregarCliente(int numeroCliente, String nombreUsuario, String password, String nombreCompleto, TipoCliente tipoCliente) {
      Cliente nuevoCliente = new Cliente(numeroCliente,tipoCliente,nombreCompleto,password);
      clientes.add(nuevoCliente);
   
    }
    
    public Cliente loginCliente(int numeroCliente, String password){

         Cliente usuarioCliente = (Cliente)buscarCliente(numeroCliente, password);
         //TIENE QUE HABER UNA EXCEPCIÓN
          if(usuarioCliente!=null){
              Dispositivo dispositivo = new Dispositivo(usuarioCliente);
              usuarioCliente.setDispositivo(dispositivo);
            //Revisar esta pavada
            //Fachada.getInstancia().avisar(Fachada.eventos.cambioListaSesiones);
        }

    }
    
    private Cliente buscarCliente(int numeroCliente, String password){

        for(Cliente c: clientes){
            if(c.getNumeroCliente() == numeroCliente && c.getPassword().equals(password)){
                return c;
            }
        }
        return null;
    }

 
    
    
    
    
}
