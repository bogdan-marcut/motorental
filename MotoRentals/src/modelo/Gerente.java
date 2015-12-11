package modelo;

import java.util.Date;

/**
 * Clase gerente.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Gerente extends Usuario {
    
    private String id;
    
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
        this.id = id;
    }

    /**
     * Constructor con todos los parametros de la clase y de la herencia.
     * 
     * @param nombre
     * @param apellidos
     * @param CC
     * @param fechaCreacion
     * @param usuario
     * @param contrasenya 
     * @param id
     */
    public Gerente(String nombre, String apellidos, String CC, Date fechaCreacion, String usuario, String contrasenya, String id) {
        super(nombre, apellidos, CC, fechaCreacion, usuario, contrasenya);
        this.id = id;
    }

    
    //Constructor para el pharsing
    public Gerente(String id, String nombre, String appelidos, String usuario, String contrasenya){
        this.id = id;
        super.nombre = nombre;
        super.apellidos = appelidos;
        super.usuario = usuario;
        super.contrasenya = contrasenya;
    }
    
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
}
