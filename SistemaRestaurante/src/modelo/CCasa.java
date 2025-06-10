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
    final double DESCUENTO_CASA = 500.0;
    double total = 0;

    for (Pedido p : pedidos) {
        total += p.getPrecio();
    }

    double totalConDescuento = total - DESCUENTO_CASA;
    if (totalConDescuento < 0) {
        totalConDescuento = 0;
    }

    String mensaje = String.format(
        "Beneficio aplicado: $%.2f por ser cliente De la Casa\n" +
        "Monto original: $%.2f\n" +
        "Total a pagar: $%.2f",
        DESCUENTO_CASA, total, totalConDescuento
    );

    return mensaje;
}

    
}
