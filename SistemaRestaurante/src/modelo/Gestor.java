package modelo;

public class Gestor extends Usuario{


    private String nombreUsuario;
    private UnidadProcesadora up;
    private boolean activo;

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
    
    
}
