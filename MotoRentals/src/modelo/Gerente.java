package modelo;

import java.util.Date;

/**
 * Clase gerente.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Gerente extends Usuario {
    
    /**
     * Constructor vacio de la clase.
     */
    public Gerente() {
        
    }

    /**
     * Constructor de la clase sin tener en cuenta la herencia.
     * 
     * @param id 
     */
    public Gerente(String id) {
        super.id = id;
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
     */
    public Gerente(String id, String nombre, String apellidos, String CC, Date fechaCreacion, String usuario, String contrasenya) {
        super(id, nombre, apellidos, CC, fechaCreacion, usuario, contrasenya);
    }

    
    /**
     * Constructor para el parsing XML.
     * 
     * @param id
     * @param nombre
     * @param appelidos
     * @param usuario
     * @param contrasenya 
     */
    public Gerente(String id, String nombre, String appelidos, String usuario, String contrasenya){
        super.id = id;
        super.nombre = nombre;
        super.apellidos = appelidos;
        super.usuario = usuario;
        super.contrasenya = contrasenya;
    }
    
}
