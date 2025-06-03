package modelo;

public class Insumo {

    private String nombre;
    private int stockMin;
    private int stock;

    public Insumo(String nombre, int stockMin, int stock) {
        this.nombre = nombre;
        this.stockMin = stockMin;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
