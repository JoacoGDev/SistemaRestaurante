package modelo;

import java.util.ArrayList;

public class Categoria {

    private String nombre;
    private ArrayList<Item> items = new ArrayList();

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
    public void agregarItem(Item i){
        items.add(i);
    }
    
    @Override
    public boolean equals(Object obj){
        Categoria c = (Categoria) obj;
        return nombre.equalsIgnoreCase(c.nombre); 
    }
    
    
    
}
