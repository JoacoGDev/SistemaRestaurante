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
            
 
            
            
            Insumo panRallado = new Insumo("Pan rallado", 10, 50);
            Insumo pollo = new Insumo("Pollo", 5, 46);
            Insumo lechuga = new Insumo("Lechuga", 5, 70);
            Insumo tomate = new Insumo("Tomate", 6, 74);
            Insumo huevo = new Insumo("Huevo", 12, 25);
            Insumo cebolla = new Insumo("Cebolla", 8, 30);
            Insumo papa = new Insumo("Papa", 15, 40);
            Insumo aceite = new Insumo("Aceite vegetal", 20, 100);
            Insumo azucar = new Insumo("Azúcar", 20, 80);
            Insumo leche = new Insumo("Leche", 10, 90);
            Insumo cafeMolido = new Insumo("Café molido", 15, 60);
            Insumo chocolate = new Insumo("Chocolate", 10, 120);
            Insumo gelatina = new Insumo("Gelatina sin sabor", 5, 30);


            Item alitas = new Item("Alitas de pollo", 300, f.obtenerUp("Cocina"));
            f.agregarItem("Entrada", alitas);
            alitas.agregarIngrediente(new Ingrediente(1, panRallado));
            alitas.agregarIngrediente(new Ingrediente(40, pollo));
            alitas.agregarIngrediente(new Ingrediente(1, huevo));

            Item ensalada = new Item("Ensalada fresca", 150, f.obtenerUp("Cocina"));
            f.agregarItem("Entrada", ensalada);
            ensalada.agregarIngrediente(new Ingrediente(3, lechuga));
            ensalada.agregarIngrediente(new Ingrediente(3, tomate));
            ensalada.agregarIngrediente(new Ingrediente(1, cebolla));


            Item polloFrito = new Item("Pollo frito", 780, f.obtenerUp("Cocina"));
            f.agregarItem("Principal", polloFrito);
            polloFrito.agregarIngrediente(new Ingrediente(2, panRallado));
            polloFrito.agregarIngrediente(new Ingrediente(3, pollo));
            polloFrito.agregarIngrediente(new Ingrediente(2, aceite));


            Item papasFritas = new Item("Papas fritas", 350, f.obtenerUp("Cocina"));
            f.agregarItem("Acompañamiento", papasFritas);
            papasFritas.agregarIngrediente(new Ingrediente(3, papa));
            papasFritas.agregarIngrediente(new Ingrediente(1, aceite));

            Item arosCebolla = new Item("Aros de cebolla", 380, f.obtenerUp("Cocina"));
            f.agregarItem("Acompañamiento", arosCebolla);
            arosCebolla.agregarIngrediente(new Ingrediente(2, cebolla));
            arosCebolla.agregarIngrediente(new Ingrediente(1, panRallado));
            arosCebolla.agregarIngrediente(new Ingrediente(1, huevo));


            Item alitasChoco = new Item("Alitas de chocolate", 230, f.obtenerUp("Cocina"));
            f.agregarItem("Postre", alitasChoco);
            alitasChoco.agregarIngrediente(new Ingrediente(2, chocolate));
            alitasChoco.agregarIngrediente(new Ingrediente(1, leche));

            Item flan = new Item("Flan casero", 200, f.obtenerUp("Cafeteria"));
            f.agregarItem("Postre", flan);
            flan.agregarIngrediente(new Ingrediente(2, huevo));
            flan.agregarIngrediente(new Ingrediente(1, leche));
            flan.agregarIngrediente(new Ingrediente(1, azucar));
            flan.agregarIngrediente(new Ingrediente(1, gelatina));


            f.agregarItem("Bebida", new Item("Coca-Cola 1L", 170, f.obtenerUp("Bar")));
            f.agregarItem("Bebida", new Item("Agua mineral 700ml", 120, f.obtenerUp("Bar")));


            f.agregarItem("Vino", new Item("Faisán", 150, f.obtenerUp("Bar")));
            f.agregarItem("Vino", new Item("Santa Teresa", 130, f.obtenerUp("Bar")));


            Item cafeNegro = new Item("Café negro", 120, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", cafeNegro);
            cafeNegro.agregarIngrediente(new Ingrediente(1, cafeMolido));

            Item expresso = new Item("Expresso", 140, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", expresso);
            expresso.agregarIngrediente(new Ingrediente(1, cafeMolido));

            Item capuchino = new Item("Capuchino", 160, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", capuchino);
            capuchino.agregarIngrediente(new Ingrediente(1, cafeMolido));
            capuchino.agregarIngrediente(new Ingrediente(1, leche));
            capuchino.agregarIngrediente(new Ingrediente(1, azucar));


            Insumo queso = new Insumo("Queso", 10, 110);
            Insumo jamon = new Insumo("Jamón", 10, 95);
            Insumo pan = new Insumo("Pan", 20, 80);
            Insumo carne = new Insumo("Carne vacuna", 8, 130);
            Insumo arroz = new Insumo("Arroz", 15, 60);
            Insumo crema = new Insumo("Crema de leche", 10, 100);
            Insumo frutilla = new Insumo("Frutilla", 10, 90);
            Insumo vainilla = new Insumo("Esencia de vainilla", 5, 50);
            Insumo hielo = new Insumo("Hielo", 50, 10);
            Insumo limon = new Insumo("Limón", 8, 40);
            Insumo manzana = new Insumo("Manzana", 3, 47);
            Insumo naranja = new Insumo("Naranja", 5, 40);
            Insumo manteca = new Insumo("Manteca", 1, 70);
            Insumo zanahoria = new Insumo("Zanahoria", 3, 34);



            Item bruschetta = new Item("Bruschetta de jamón y queso", 250, f.obtenerUp("Cocina"));
            f.agregarItem("Entrada", bruschetta);
            bruschetta.agregarIngrediente(new Ingrediente(1, pan));
            bruschetta.agregarIngrediente(new Ingrediente(1, jamon));
            bruschetta.agregarIngrediente(new Ingrediente(1, queso));

            Item sopaVerduras = new Item("Sopa de verduras", 220, f.obtenerUp("Cocina"));
            f.agregarItem("Entrada", sopaVerduras);
            sopaVerduras.agregarIngrediente(new Ingrediente(2, cebolla));
            sopaVerduras.agregarIngrediente(new Ingrediente(1, papa));
            sopaVerduras.agregarIngrediente(new Ingrediente(1, zanahoria));


            Item hamburguesa = new Item("Hamburguesa completa", 850, f.obtenerUp("Cocina"));
            f.agregarItem("Principal", hamburguesa);
            hamburguesa.agregarIngrediente(new Ingrediente(1, pan));
            hamburguesa.agregarIngrediente(new Ingrediente(1, carne));
            hamburguesa.agregarIngrediente(new Ingrediente(1, queso));
            hamburguesa.agregarIngrediente(new Ingrediente(1, lechuga));
            hamburguesa.agregarIngrediente(new Ingrediente(1, tomate));

            Item arrozPollo = new Item("Arroz con pollo", 700, f.obtenerUp("Cocina"));
            f.agregarItem("Principal", arrozPollo);
            arrozPollo.agregarIngrediente(new Ingrediente(3, arroz));
            arrozPollo.agregarIngrediente(new Ingrediente(2, pollo));
            arrozPollo.agregarIngrediente(new Ingrediente(1, cebolla));


            Item purePapa = new Item("Puré de papa", 320, f.obtenerUp("Cocina"));
            f.agregarItem("Acompañamiento", purePapa);
            purePapa.agregarIngrediente(new Ingrediente(3, papa));
            purePapa.agregarIngrediente(new Ingrediente(1, leche));
            purePapa.agregarIngrediente(new Ingrediente(1, manteca));

            Item mousseChocolate = new Item("Mousse de chocolate", 260, f.obtenerUp("Cocina"));
            f.agregarItem("Postre", mousseChocolate);
            mousseChocolate.agregarIngrediente(new Ingrediente(2, chocolate));
            mousseChocolate.agregarIngrediente(new Ingrediente(1, crema));
            mousseChocolate.agregarIngrediente(new Ingrediente(1, huevo));

            Item ensaladaFrutas = new Item("Ensalada de frutas", 210, f.obtenerUp("Cocina"));
            f.agregarItem("Postre", ensaladaFrutas);
            ensaladaFrutas.agregarIngrediente(new Ingrediente(2, frutilla));
            ensaladaFrutas.agregarIngrediente(new Ingrediente(2, manzana));
            ensaladaFrutas.agregarIngrediente(new Ingrediente(1, naranja));

            Item limonada = new Item("Limonada fresca", 140, f.obtenerUp("Bar"));
            f.agregarItem("Bebida", limonada);
            limonada.agregarIngrediente(new Ingrediente(2, limon));
            limonada.agregarIngrediente(new Ingrediente(1, azucar));
            limonada.agregarIngrediente(new Ingrediente(2, hielo));

            Item licuadoFrutilla = new Item("Licuado de frutilla", 180, f.obtenerUp("Bar"));
            f.agregarItem("Bebida", licuadoFrutilla);
            licuadoFrutilla.agregarIngrediente(new Ingrediente(3, frutilla));
            licuadoFrutilla.agregarIngrediente(new Ingrediente(1, leche));
            licuadoFrutilla.agregarIngrediente(new Ingrediente(1, azucar));

            Item latte = new Item("Latte", 150, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", latte);
            latte.agregarIngrediente(new Ingrediente(1, cafeMolido));
            latte.agregarIngrediente(new Ingrediente(1, leche));

            Item mocaccino = new Item("Mocaccino", 170, f.obtenerUp("Cafeteria"));
            f.agregarItem("Cafe", mocaccino);
            mocaccino.agregarIngrediente(new Ingrediente(1, cafeMolido));
            mocaccino.agregarIngrediente(new Ingrediente(1, leche));
            mocaccino.agregarIngrediente(new Ingrediente(1, chocolate));
       
            
            TipoCliente comun = new CComun();
            TipoCliente casa = new CCasa();
            TipoCliente frecuente = new CFrecuente(f.getItems("Cafe"));
            TipoCliente preferencial = new CPreferencial();


            f.agregarTipoCliente(comun);
            f.agregarTipoCliente(casa);
            f.agregarTipoCliente(frecuente);
            f.agregarTipoCliente(preferencial);


            f.agregarCliente(1, "1", "1", "Juan Paco Pedro De La Mar", comun);          
            f.agregarCliente(2, "2", "2", "Pedrito Pedrón", casa);                   
            f.agregarCliente(3, "3", "3", "Andresitooo", frecuente);                 
            f.agregarCliente(4, "4", "4", "Julian Mazza", preferencial);               

// Agregar más clientes para testear mejor cada caso
            f.agregarCliente(5, "5", "5", "Laura Común", comun);
            f.agregarCliente(6, "6", "6", "Carlos Casa", casa);
            f.agregarCliente(7, "7", "7", "María Cafetera", frecuente);
            f.agregarCliente(8, "8", "8", "Tito Preferido", preferencial);

            
            f.agregarGestores("Juan Carlos", "1", "1", f.obtenerUp("Cocina"));
            f.agregarGestores("Pedro Pascal", "Pedrito", "PedroPedrin", f.obtenerUp("Cocina"));
            f.agregarGestores("Carlo", "ElCarli", "Carlangas", f.obtenerUp("Cocina"));
            f.agregarGestores("Agustin", "Agustin51", "ElFornais", f.obtenerUp("Cocina"));
            


        }
        catch(RestauranteException ex){
            System.out.println(ex.getMessage());
        }
    }
}
