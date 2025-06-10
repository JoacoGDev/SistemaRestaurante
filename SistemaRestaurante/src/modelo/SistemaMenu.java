
package modelo;

import java.util.ArrayList;


public class SistemaMenu {
    
    private Menu menuActual;
    

    public SistemaMenu() {
        this.menuActual = menuActual;
    }
    
    public Menu getMenuActual() {
        return menuActual;
    }
    
    public void setMenuActual(Menu menuActual){
        this.menuActual = menuActual; 
    }
    
    public void agregarCategoria(Categoria c){
        menuActual.agregarCategoria(c);
    }
    
    public void agregarItem(String cat, Item i){
        menuActual.agregarItem(cat, i);
    }
    
    public ArrayList<Categoria> getCategoria(){
        return this.menuActual.getCategorias();
    }
    
    public ArrayList<Item> getItems(String nom) {
        Categoria c = menuActual.buscarCategoria(nom);
        ArrayList<Item> items = menuActual.getItem(c);
        ArrayList<Item> itemsConStock = new ArrayList<>();
        
        for(Item i: items){
            if(i.isDisponible()){
                itemsConStock.add(i);
            }
        }
        return itemsConStock;
    }
    

    
    
}
