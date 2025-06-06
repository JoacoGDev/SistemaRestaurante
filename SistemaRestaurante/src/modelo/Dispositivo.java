package modelo;

public class Dispositivo {
    private static int contadorId = 0;
    private int id;
    private Cliente cliente;
    private EstadoDispositivo estado;
    private Servicio servicio;

    public Dispositivo(Cliente cliente) {
        this.id  = ++ contadorId;
        this.cliente = cliente;
    }
    
    public Dispositivo() {
        this.id  = ++ contadorId;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoDispositivo getEstado() {
        return estado;
    }

    public void setServicio(Servicio servicio){ this.servicio = servicio;}

    public void setEstado(EstadoDispositivo estado) {
        this.estado = estado;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    
}
