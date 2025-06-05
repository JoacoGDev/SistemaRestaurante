package modelo;

public class Cliente extends Usuario {
    
    private final int numeroCliente;
    private TipoCliente tipoCliente;
    private Dispositivo dispositivo;

    public Cliente(int numeroCliente, TipoCliente tipoCliente, String nombreCompleto, String password) {
        super(nombreCompleto, password);
        this.numeroCliente = numeroCliente;
        this.tipoCliente = tipoCliente;
        this.dispositivo = null;
    }


    public int getNumeroCliente() {
        return numeroCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public Dispositivo getDispositivo(){
        return dispositivo;
    }
}
