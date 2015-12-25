package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase cliente.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Cliente extends Usuario {
    
    private int faltas;
    private Direccion direccion;
    
    /**
     * Constructor vacio de la clase.
     */
    public Cliente() {
        
    }

    /**
     * Constructor de la clase sin tener en cuenta la herencia.
     * 
     * @param faltas 
     */
    public Cliente(int faltas) {
        this.faltas = faltas;
    }

    /**
     * Constructor con todos los parametros de la clase y de la herencia.
     * 
     * @param id
     * @param nombre
     * @param apellidos
     * @param CC
     * @param fechaCreacion
     * @param usuario
     * @param contrasenya 
     * @param faltas
     */
    public Cliente(String id, String nombre, String apellidos, String CC, Date fechaCreacion, String usuario, String contrasenya, int faltas, Direccion direccion) {
        super(id, nombre, apellidos, CC, fechaCreacion, usuario, contrasenya);
        this.faltas = faltas;
        this.direccion = direccion;
    }

    /**
     * @return the faltas
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Apunta una falta al cliente.
     * 
     */
    public void apuntarFalta(){
        this.faltas++;
    }
    
    @Override
    public String toString() {
        String s = super.toString();
        s += "Direccion: " + direccion + "\n";
        s += "Faltas:" + faltas + "\n";
        return s;
    }

}
