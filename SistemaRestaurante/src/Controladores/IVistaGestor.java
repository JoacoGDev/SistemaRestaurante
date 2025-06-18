/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author joaco
 */
public interface IVistaGestor {
    
    public void cargarPedidos(ArrayList<Pedido> pedidos);
    public void cargarTablaPedidos(ArrayList<Pedido> pedidos);
    public void mostrarError(String error);
}
