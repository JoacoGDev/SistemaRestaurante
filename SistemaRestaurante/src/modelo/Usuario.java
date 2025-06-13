/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joaco
 */
public abstract class Usuario {
    
    private String nombreCompleto;
    private String password; 

    public Usuario(String nombreCompleto, String password) {
        this.nombreCompleto = nombreCompleto;
        this.password = password;
    }
    

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {return nombreCompleto;}
    
    
    
    
}
