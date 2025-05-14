package sistemarestaurante.logica;

public class Cliente {
    private int id;
    private String password;
    private String nombreCompleto;
    private TipoCliente tipoCliente;

    public Cliente(int id, String contrasena, String nombreCompleto, TipoCliente tipoCliente) {
        this.id = id;
        this.password = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.tipoCliente = tipoCliente;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
