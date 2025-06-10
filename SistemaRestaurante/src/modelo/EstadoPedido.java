package modelo;

//CAMBIAR DE ENUM A STATE O STRATEGY 

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
