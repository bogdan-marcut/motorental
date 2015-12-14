package modelo;

/**
 * Clase administrador.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Administrador extends Usuario{
    
    public Administrador(){
        
    }
    
    /**
     * Constructor para el parsing XML.
     * 
     * @param id
     * @param nombre
     * @param usuario
     * @param contrasenya 
     */
    public Administrador(String id, String nombre, String usuario, String contrasenya){
        super.id = id;
        super.nombre = nombre;
        super.usuario = usuario;
        super.contrasenya = contrasenya;
    }
    
}
