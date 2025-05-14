package sistemarestaurante.logica;

import java.util.ArrayList;

public class Servicio {
    private ArrayList <Pedidos> pedidos = new ArrayList<>();
    private double montoTotal;

    public Servicio() {
        montoTotal = 0;
    }

    public ArrayList<Pedidos> getPedidos() {
        return pedidos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
