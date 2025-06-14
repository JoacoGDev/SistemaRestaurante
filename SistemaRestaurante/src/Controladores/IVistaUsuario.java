/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.Item;
import modelo.Pedido;
import modelo.Servicio;

/**
 *
 * @author joaco
 */
public interface IVistaUsuario {
    
    public void MostrarUsuario(String nombreUsuario);

    public void mostrarMensaje(String message);
    
    public void cargarCategorias(ArrayList<Categoria> categorias);

    public void cargarItems(ArrayList<Item> items);
    
    public void actualizarTabla(ArrayList<Pedido> pedidos);
    
    public void mostrarConfirmar();
    
    public void limpiarCampos();
    
    public void procesarCategoria();
         
     
    
}
