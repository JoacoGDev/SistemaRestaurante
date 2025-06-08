package modelo;

public enum EstadoPedido {
    NOCONFIRMADO("No confirmado"), 
    CONFIRMADO("Confirmado"), 
    ENPROCESO("En proceso"), 
    FINALIZADO("Finalizado"), 
    ENTREGADO("Entregado");
    
    private String nombre;

    private EstadoPedido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
