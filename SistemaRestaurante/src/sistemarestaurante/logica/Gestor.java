package sistemarestaurante.logica;

public class Gestor {

    private String nombreCompleto;
    private String usuario;
    private String password;
    private boolean activo;

    public Gestor(String nombre, String nombreUsuario, String pwd){
        nombreCompleto = nombre;
        usuario = nombreUsuario;
        password = pwd;
        activo = false;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
