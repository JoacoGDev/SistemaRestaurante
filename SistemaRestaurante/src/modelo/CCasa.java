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
public class CCasa extends TipoCliente{

    public CCasa() {
        super("De la casa");
    }

    @Override
    public String descuento(ArrayList<Pedido> pedidos) {
        String ret = "";
        double total = 0;
        for (Pedido p : pedidos){
            total += p.getPrecio();
        }
        total = total - 500;
        ret = "Te invitamos $500 de la casa! - Beneficio: 500 - Total: " + total;
        return ret;

    }
    
}
