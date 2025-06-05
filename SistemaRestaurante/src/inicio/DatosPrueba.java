/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import modelo.Fachada;
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
            f.agregarCliente(323, "Juan", "Juan", "Juan Paco Pedro De La Mar", TipoCliente.COMUNES);
            f.agregarCliente(232, "Pedro", "pedro", "Pedrito  Pedrón", TipoCliente.DELACASA);
            f.agregarCliente(123, "Andrés", "andres", "Andresitooo", TipoCliente.PREFERENCIALES);
        }
        catch(RestauranteException ex){
            
        }
    }
}
