/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estados;

import modelo.Pedido;
import modelo.Pedido.EstadoPedido;
import modelo.RestauranteException;

/**
 *
 * @author joaco
 */
public class EstadoNoConfirmado extends EstadoPedidos{

    public EstadoNoConfirmado(Pedido pedido) {
        super(pedido, EstadoPedido.noConfirmado, "No confirmado");
    }
    

    @Override
    public void confirmar() {
        getPedido().cambiarEstado(new EstadoConfirmado(getPedido()));
    }

    @Override
    public void procesar() throws RestauranteException{
        throw new RestauranteException("El pedido no está confirmado");
    }

    @Override
    public void finalizar()  throws RestauranteException{
        throw new RestauranteException("El pedido no está confirmado");
    }

    @Override
    public void entregar() throws RestauranteException{
        throw new RestauranteException("El pedido no está confirmado");
    }
    
}
