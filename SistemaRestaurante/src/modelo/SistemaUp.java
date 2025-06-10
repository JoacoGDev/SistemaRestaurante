package modelo;

import java.util.ArrayList;

public class SistemaUp {
    private ArrayList<UnidadProcesadora> unidadesP;

    public SistemaUp() {
        this.unidadesP = new ArrayList<>();
    }
    
    public void agregarUp(String nom){
        UnidadProcesadora up = new UnidadProcesadora(nom);
        unidadesP.add(up);
    }

    public UnidadProcesadora obtnereUp(String nom) throws RestauranteException{
        for (UnidadProcesadora up : unidadesP){
            if (up.getNombre().equals(nom)){
                return up;
            }
        }
        throw new RestauranteException("ERROR NO SE ENCONTRO LA UP EN LOS DATOS DE PRUEBA");
    }
}
