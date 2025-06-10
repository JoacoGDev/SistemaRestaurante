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
public class CPreferencial extends TipoCliente{

    public CPreferencial() {
        super("Preferencial");
    }

    @Override
    public String descuento(ArrayList<Pedido> pedidos) {
        String ret = "";
        double total = 0;
        for (Pedido p : pedidos){
            if (p.getItems().getNombre().equals("Agua mineral 700ml")){
                ret += "Cafe invitacion - Beneficio: " + p.getPrecio();
            }
            else
            {
                total += p.getPrecio();
            }
        }
        ret += " - " + total;
        return ret;
    }
    
    
}
