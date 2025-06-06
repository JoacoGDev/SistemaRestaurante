package modelo;

public class Gestor extends Usuario{


    private String nombreUsuario;
    private boolean activo;

    public Gestor(String nombreUsuario, String nombreCompleto, String password) {
        super(nombreCompleto, password);
        this.nombreUsuario = nombreUsuario;
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
}
