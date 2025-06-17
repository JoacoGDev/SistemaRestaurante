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
public class EstadoConfirmado extends EstadoPedidos{

     public EstadoConfirmado(Pedido pedido) {
        super(pedido, Pedido.EstadoPedido.confirmado, "Confirmado");
    }

   @Override
    public void confirmar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está confirmado");
    }

    @Override
    public void procesar() throws RestauranteException{
          getPedido().cambiarEstado(new EstadoEnProceso(getPedido()));
    }

    @Override
    public void finalizar()  throws RestauranteException{
        throw new RestauranteException("El pedido no está confirmado ni procesado");
    }

    @Override
    public void entregar() throws RestauranteException{
        throw new RestauranteException("El pedido no está confirmado, procesado ni finalizado");
    }
    
    
}
