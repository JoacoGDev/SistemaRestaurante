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
public class Fachada {
    
    private SistemaUsuarios sUsuario = new SistemaUsuarios();
    private SistemaMenu sMenu = new SistemaMenu();
    
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }
    
    public void agregarCliente(int numeroCliente, String nombreUsuario, String password, String nombreCompleto, TipoCliente tipoCliente) throws RestauranteException {
        sUsuario.agregarCliente(numeroCliente, nombreUsuario, password, nombreCompleto, tipoCliente);
    }
    
     public void agregarGestores(String nombreCompleto, String password, String nombreUsuario) throws RestauranteException {
        sUsuario.agregarGestores(nombreCompleto, password, nombreUsuario);
    }
     

    public Cliente loginCliente(int numeroCliente, String password) throws RestauranteException {
        return sUsuario.loginCliente(numeroCliente, password);
    }

    public Menu getMenu() {
        return sMenu.getMenuActual();
    }

    public ArrayList<Categoria> getCategoria() {
        return sMenu.getCategoria();
    }

    public void setMenu(Menu m) {
        sMenu.setMenuActual(m);
    }

    public void agregarCategoria(Categoria c) {
        sMenu.agregarCategoria(c);
    }

    public void agregarItem(String cat, Item i) {
        sMenu.agregarItem(cat, i);
    }

    public ArrayList<Item> getItems(Categoria c) {
        return sMenu.getItems(c);
    }
}
    


