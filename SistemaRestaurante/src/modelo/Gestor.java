package modelo;

public class Gestor extends Usuario{


    private String nombreUsuario;
    private boolean activo;

    public Gestor(String nombreUsuario, boolean activo, String nombreCompleto, String password) {
        super(nombreCompleto, password);
        this.nombreUsuario = nombreUsuario;
        this.activo = activo;
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
}
