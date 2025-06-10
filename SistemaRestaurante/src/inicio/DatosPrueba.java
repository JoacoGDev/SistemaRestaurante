/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import modelo.CCasa;
import modelo.CComun;
import modelo.CFrecuente;
import modelo.CPreferencial;
import modelo.Categoria;
import modelo.Fachada;
import modelo.Ingrediente;
import modelo.Insumo;
import modelo.Item;
import modelo.Menu;
import modelo.RestauranteException;
import modelo.TipoCliente;
import modelo.UnidadProcesadora;

/**
 *
 * @author joaco
 */
public class DatosPrueba {
    
    /*
    TO DO:
    
    Categoria - Terminado
    Dispositivo - Terminado
    Servicio - Terminado, se hace con el dispositivo
    Menu - Terminado
    Unidad Procesadora - Terminado
    Usuario - Terminado
    Cliente - Terminado
    Gestor - Terminado
    Pedido - Falta hacer Estado pedido con state o strategy
    Item - Faltan ingredientes
    Insumo - Falta todo
    Ingrediente - Falta todo
    */
    
    public static void cargar(){
        
        Fachada f = Fachada.getInstancia();
        try{
            
            
            
            f.agregarDispositivo();
            f.agregarDispositivo();
            
   
            f.agregarUp("Bar");
            f.agregarUp("Cocina");
            f.agregarUp("Cafeteria");
            
            f.setMenu(new Menu());
            f.agregarCategoria(new Categoria("Entrada"));
            f.agregarCategoria(new Categoria("Principal"));
            f.agregarCategoria(new Categoria("Acompañamiento"));
            f.agregarCategoria(new Categoria("Postre"));
            f.agregarCategoria(new Categoria("Bebida"));
            f.agregarCategoria(new Categoria("Vino"));
            f.agregarCategoria(new Categoria("Cafe"));
            
            TipoCliente tc = new CComun();
            f.agregarTipoCliente(tc);
            f.agregarCliente(1, "1", "1", "Juan Paco Pedro De La Mar", tc);
            tc = new CCasa();
            f.agregarTipoCliente(tc);
            f.agregarCliente(2, "2", "2", "Pedrito  Pedrón", tc);
            tc = new CFrecuente(f.getItems("Cafe"));
            f.agregarTipoCliente(tc);
            f.agregarCliente(3, "3", "3", "Andresitooo", tc);
            tc = new CPreferencial();
            f.agregarTipoCliente(tc);
            f.agregarCliente(4, "4", "4", "Julian Mazza", tc);
            
            f.agregarGestores("Juan Carlos", "1", "1", f.obtenerUp("Cocina"));
            f.agregarGestores("Pedro Pascal", "Pedrito", "PedroPedrin", f.obtenerUp("Cocina"));
            f.agregarGestores("Carlo", "ElCarli", "Carlangas", f.obtenerUp("Cocina"));
            f.agregarGestores("Agustin", "Agustin51", "ElFornais", f.obtenerUp("Cocina"));
            
            

            Insumo i = new Insumo("Pan rallado", 10, 50);
            Item it = new Item("Alitas de pollo", 300, f.obtenerUp("Cocina"));
            Ingrediente in = new Ingrediente(1, i);
            f.agregarItem("Entrada", it);
            it.agregarIngrediente(in);
            Item it2 = new Item("Pollo frito", 780, f.obtenerUp("Cocina"));
            f.agregarItem("Principal", it2);
            in = new Ingrediente(2, i);
            it2.agregarIngrediente(in);
            

            i = new Insumo("Pollo", 5, 46);
            in = new Ingrediente(40, i);
            it.agregarIngrediente(in);
            in = new Ingrediente(3, i);
            it2.agregarIngrediente(in);

            i = new Insumo ("Lechuga", 5, 70);
            it = new Item("Ensalada", 150, f.obtenerUp("Cocina"));
            f.agregarItem("Entrada", it);
            in = new Ingrediente(3, i);
            it.agregarIngrediente(in);

            i = new Insumo("Tomate", 6, 74);
            in = new Ingrediente(3, i);
            it.agregarIngrediente(in);

            it =new Item("Alitas de chocolate", 230, f.obtenerUp("Cocina"));
            f.agregarItem("Postre", it);

            it = new Item("Flan", 200, f.obtenerUp("Cafeteria"));
            f.agregarItem("Postre", it);

            it = new Item("Papas fritas", 350, f.obtenerUp("Cocina"));
            f.agregarItem("Acompañamiento", it);

            it = new Item("Aros de cebolla", 380, f.obtenerUp("Cocina"));
            f.agregarItem("Acompañamiento", it);

            it = new Item("Coca 1L", 170, f.obtenerUp("Bar"));
            f.agregarItem("Bebida", it);

            it = new Item("Agua mineral 700ml", 120, f.obtenerUp("Bar"));
            f.agregarItem("Bebida", it);

            it = new Item("Faisan", 150, f.obtenerUp("Bar"));
            f.agregarItem("Vino", it);

            it = new Item("Santa teresa", 130, f.obtenerUp("Bar"));
            f.agregarItem("Vino", it);

            it = new Item("Negro", 120, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", it);

            it = new Item("Expresso", 140, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", it);

            it = new Item("Capuchino", 160, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", it);








        }
        catch(RestauranteException ex){
            System.out.println(ex.getMessage());
        }
    }
}
