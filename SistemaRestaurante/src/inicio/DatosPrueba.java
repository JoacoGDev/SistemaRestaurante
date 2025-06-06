/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import modelo.Categoria;
import modelo.Fachada;
import modelo.Item;
import modelo.Menu;
import modelo.RestauranteException;
import modelo.TipoCliente;

/**
 *
 * @author joaco
 */
public class DatosPrueba {
    
    public static void cargar(){
        
        Fachada f = Fachada.getInstancia();
        try{
            f.agregarCliente(1, "1", "1", "Juan Paco Pedro De La Mar", TipoCliente.COMUNES);
            f.agregarCliente(232, "Pedro", "pedro", "Pedrito  Pedrón", TipoCliente.DELACASA);
            f.agregarCliente(123, "Andrés", "andres", "Andresitooo", TipoCliente.PREFERENCIALES);
            
            f.setMenu(new Menu());
            f.agregarCategoria(new Categoria("Entrada"));
            f.agregarCategoria(new Categoria("Principal"));
            f.agregarCategoria(new Categoria("Postre"));
            f.agregarCategoria(new Categoria("Bebida"));
            f.agregarCategoria(new Categoria("Vino"));
            f.agregarCategoria(new Categoria("Cafe"));
            
            f.agregarItem("Entrada", new Item("choclo", 15));
            f.agregarItem("Entrada", new Item("1", 15));
            f.agregarItem("Entrada", new Item("2", 15));
            f.agregarItem("Entrada", new Item("3", 15));
            
            f.agregarItem("Principal", new Item("papa", 15));
            f.agregarItem("Principal", new Item("4", 15));
            f.agregarItem("Principal", new Item("5", 15));
            f.agregarItem("Principal", new Item("6", 15));
            
            
        }
        catch(RestauranteException ex){
            
        }
    }
}
