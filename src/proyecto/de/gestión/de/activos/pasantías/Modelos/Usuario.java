/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.de.gestión.de.activos.pasantías.Modelos;

/**
 *
 * @author JUNIORCEDE
 */
public class Usuario {
    private String username;
    private String tipo;

    public Usuario(String username, String tipo) {
        this.username = username;
        this.tipo = tipo;
    }
    
    public String getUerName(){
        return this.username;
    }
    
    public String getTipo(){
        return this.tipo;
    }
}
