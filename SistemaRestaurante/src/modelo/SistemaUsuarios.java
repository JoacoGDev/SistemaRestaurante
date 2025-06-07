/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;


public class SistemaUsuarios {
    
    public ArrayList<Cliente> clientes = new ArrayList();
    public ArrayList<Gestor> gestores = new ArrayList();


    public void agregarCliente(int numeroCliente, String nombreUsuario, String password, String nombreCompleto, TipoCliente tipoCliente) throws RestauranteException {
        // Verificamos si el número de cliente ya existe
        for (Cliente c : clientes) {
            if (c.getNumeroCliente() == numeroCliente) {
                throw new RestauranteException("El número de cliente ya está registrado");
            }
        }
    
        Cliente nuevoCliente = new Cliente(numeroCliente, tipoCliente, nombreCompleto, password);
        clientes.add(nuevoCliente);
    }
    
       public void agregarGestores(String nombreCompleto, String password, String nombreUsuario) throws RestauranteException {
        // Verificamos si el número de cliente ya existe
        for (Gestor g : gestores) {
            if (g.getUsuario().equals(nombreUsuario)) {
                throw new RestauranteException("El Gestor ya está registrado");
            }
        }
    
        Gestor nuevoGestor = new Gestor(nombreCompleto, password, nombreCompleto);
        gestores.add(nuevoGestor);
    }

    
    public Cliente loginCliente(int numeroCliente, String password, Dispositivo dispositivo)throws RestauranteException{

         Cliente usuarioCliente = buscarCliente(numeroCliente);
         
        //Verifica si el cliente no existe o la contraseña está mal
        if (usuarioCliente == null || !usuarioCliente.getPassword().equals(password)) {
            throw new RestauranteException("Credenciales incorrectas");
        }
         
         //Verifica que el usuario no esté logueado
          if (usuarioCliente.getDispositivo() != null) {
            throw new RestauranteException("El usuario ya se encuentra identificado en otro dispositivo");
          }
          
          if(dispositivo.getCliente() != null){
              throw new RestauranteException("Debe finalizar el servicio");
          }
          dispositivo.setCliente(usuarioCliente);
          dispositivo.setServicio(new Servicio());
          usuarioCliente.setDispositivo(dispositivo);

          return usuarioCliente;

    }
    
    private Cliente buscarCliente(int numeroCliente){

        for(Cliente c: clientes){
            if(c.getNumeroCliente() == numeroCliente){
                return c;
            }
        }
        return null;
    }

 
    
    
    
    
}
