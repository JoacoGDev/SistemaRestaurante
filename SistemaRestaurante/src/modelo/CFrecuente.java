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
public class CFrecuente extends TipoCliente{

    private ArrayList<Item> cafes;
    
    public CFrecuente(ArrayList<Item> cafes) {
        super("Frecuente");
        this.cafes = cafes;
    }

    @Override
    public String descuento(ArrayList<Pedido> pedidos) {
        String ret = "";
        double total = 0;
        for (Pedido p : pedidos){
            if (cafes.contains(p.getItems())){
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
