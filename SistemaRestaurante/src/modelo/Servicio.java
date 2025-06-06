package modelo;

import java.util.ArrayList;

public class Servicio {
    private ArrayList <Pedido> pedidos = new ArrayList<>();
    private double montoTotal;

    public Servicio() {
        montoTotal = 0;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
