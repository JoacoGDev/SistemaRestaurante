package modelo;

public class Ingrediente {

    private int cantidad;
    private Insumo insumo;

    public Ingrediente(int cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public boolean isDisponible() {
        return (insumo.getStock() - cantidad) > insumo.getStockMin();
    }


    public void descontarStock() throws RestauranteException {
        this.insumo.descontarStock(cantidad);
    }

    void reintegrarStock() {
         this.insumo.reintegrarStock(cantidad);
    }
}
