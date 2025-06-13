package modelo;

import Controladores.ControladorGestores;
import java.util.ArrayList;

public class Gestor extends Usuario{


    private String nombreUsuario;
    private UnidadProcesadora up;
    private boolean activo;
    private ArrayList<Pedido> pedidosTomados = new ArrayList<Pedido>();

    public Gestor(String nombreUsuario, String nombreCompleto, String password, UnidadProcesadora up) {
        super(nombreCompleto, password);
        this.nombreUsuario = nombreUsuario;
        this.up = up;
        activo = false;
    }

    public String getUsuario() {
        return nombreUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public UnidadProcesadora getUp() {
        return up;
    }
    
    
    public ArrayList<Pedido> obtenerPedidosUp(){
        return up.getPedidos();
    }

    public void agregarObs(ControladorGestores aThis) {
        up.agregarObservador(aThis);
    }

    public void tomarPedido(Pedido p) {
        p.setGestor(this);
    }
    
    
}
