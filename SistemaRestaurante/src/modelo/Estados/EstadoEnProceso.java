/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estados;


import modelo.Pedido;
import modelo.RestauranteException;

/**
 *
 * @author joaco
 */
public class EstadoEnProceso extends EstadoPedidos{

     public EstadoEnProceso(Pedido pedido) {
        super(pedido, Pedido.EstadoPedido.enProceso, "En proceso");
    }
     
     
    @Override
    public void confirmar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está en proceso");
    }

    @Override
    public void procesar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está en proceso");
    }

    @Override
    public void finalizar() {
        getPedido().cambiarEstado(new EstadoFinalizado(getPedido()));
    }

    @Override
    public void entregar() throws RestauranteException{
        throw new RestauranteException("El pedido no está finalizado");
    }
    
}
