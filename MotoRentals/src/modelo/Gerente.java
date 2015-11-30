package modelo;

import java.util.Date;

/**
 * Clase gerente.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Gerente extends Usuario {
    
    private int id;
    
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
    public Gerente(int id) {
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
    public Gerente(String nombre, String apellidos, String CC, Date fechaCreacion, String usuario, String contrasenya, int id) {
        super(nombre, apellidos, CC, fechaCreacion, usuario, contrasenya);
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
