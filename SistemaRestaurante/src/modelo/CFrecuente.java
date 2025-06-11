/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class CFrecuente extends TipoCliente {

    private ArrayList<Item> cafes;

    public CFrecuente(ArrayList<Item> cafes) {
        super("Frecuente");
        this.cafes = cafes;
    }

    @Override
    public String descuento(ArrayList<Pedido> pedidos) {
        StringBuilder ret = new StringBuilder();
        double total = 0;

        for (Pedido p : pedidos) {
            Item item = p.getItems();
            if (cafes.contains(item)) {
                ret.append("Café invitación: ").append(item.getNombre())
                        .append(" (").append(item.getPrecio()).append(")\n");
            } else {
                total += item.getPrecio();
            }
        }

        ret.append("Total a pagar: $").append(total);
        return ret.toString();
    }
}
