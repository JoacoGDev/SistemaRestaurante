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
        cargarPedidos();
    }
    
    public void cargarPedidos(){
        vGestor.cargarPedidos(gestor.obtenerPedidosUp());
    }
    
    public void tomarPedido(Pedido pedidoSeleccionado) {
        try{
            gestor.tomarPedido(pedidoSeleccionado);
            vGestor.cargarTablaPedidos(gestor.getPedidosTomados());
        }
        catch (RestauranteException ex){
        }
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(UnidadProcesadora.eventos.cambioListaPedidosUp)){
            cargarPedidos();
        }
    }

    public void finalizarPedido(int ind) {
        try{
            gestor.finalizarPedido(ind);
             vGestor.cargarTablaPedidos(gestor.getPedidosTomados());
            
        }catch(RestauranteException ex){
            
        }
    }

    public void entregarPedido(int ind) {
         try{
            gestor.entregarPedido(ind);
             vGestor.cargarTablaPedidos(gestor.getPedidosTomados());
            
        }catch(RestauranteException ex){
            
        }
    }

    
}
