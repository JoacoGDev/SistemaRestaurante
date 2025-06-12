package Controladores;

import modelo.Fachada;
import modelo.Gestor;
import modelo.Pedido;
import modelo.RestauranteException;
import modelo.UnidadProcesadora;
import observador.Observable;
import observador.Observador;

public class ControladorGestores implements Observador{
    private Fachada f = Fachada.getInstancia();
    private IVistaGestor vGestor;
    private Gestor gestor;

    
    public ControladorGestores(IVistaGestor vistaGestor, Gestor gestorLogueado){
        vGestor = vistaGestor;
        gestor = gestorLogueado;
        gestor.agregarObs(this);
    }
    
    public void cargarPedidos(){
        vGestor.cargarPedidos(gestor.obtenerPedidosUp());
    }
    
    public void tomarPedido(Pedido pedidoSeleccionado) {
        gestor.tomarPedido(pedidoSeleccionado);
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(UnidadProcesadora.eventos.cambioListaPedidosUp)){
            cargarPedidos();
        }
    }

    
}
