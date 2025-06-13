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
public class EstadoEntregado extends EstadoPedidos{

       public EstadoEntregado(Pedido pedido) {
        super(pedido, Pedido.EstadoPedido.entregado);
    }
     

    @Override
    public void confirmar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está entregado");
    }

    @Override
    public void procesar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está entregado");
    }

    @Override
    public void finalizar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está entregado");
    }

    @Override
    public void entregar() throws RestauranteException{
        throw new RestauranteException("El pedido ya está entregado");
    }
    
}
