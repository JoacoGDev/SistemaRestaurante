package modelo;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Categoria> categorias = new ArrayList();

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    

    public void agregarCategoria(Categoria c){
        /*for(Categoria c1 : categorias){
            if (c.equals(c1)){
                return; //EXCEPTION
            }
        }*/
        categorias.add(c);
        
    }
    
    public void agregarItem(String cat, Item i){
        Categoria c = buscarCategoria(cat);
        if (c != null){
            c.agregarItem(i);
        }
    }
    
    public Categoria buscarCategoria(String cat){
        for (Categoria c : categorias){
            if (c.getNombre().equals(cat)){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Item> getItem(Categoria c) {
        return c.getItems();
    }
    
    
}
