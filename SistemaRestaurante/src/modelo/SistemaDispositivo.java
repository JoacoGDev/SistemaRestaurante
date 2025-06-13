/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author joaco
 */
public class SistemaDispositivo {
    private ArrayList<Dispositivo> dispositivos;

    public SistemaDispositivo() {
        this.dispositivos = new ArrayList<Dispositivo>();
    }
    
    
    public void crearDispositivo(){
        Dispositivo nuevoDispositivo = new Dispositivo();
        dispositivos.add(nuevoDispositivo);
    }

    public Dispositivo getDispositivoDisponible() {
        for(Dispositivo d: dispositivos){
            if(d.isDisponible()){
                d.setDisponible(false);
                return d;
            }
        }
        return null;
    }

    public Pedido agregarPedido(Item item, String comentario, Dispositivo dispositivoUsuario) throws RestauranteException {
        return dispositivoUsuario.agregarPedido(item, comentario);
    }
       
            
    
}