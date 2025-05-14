package sistemarestaurante.logica;

import java.util.ArrayList;

public class Pedidos {
    private ArrayList<Item> items = new ArrayList<>();
    private String comentario;
    private EstadoPedido estado;
    private Gestor gestor;

    public Pedidos(String comentario, EstadoPedido estado, Gestor gestor) {
        this.comentario = comentario;
        this.estado = estado;
        this.gestor = gestor;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
}
