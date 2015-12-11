package modelo;

import java.util.Date;

/**
 * Clase general de usuario.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public abstract class Usuario {
    
    protected String nombre;
    protected String apellidos;
    protected String CC;
    protected Date fechaCreacion;
    protected String usuario;
    protected String contrasenya;
    
    /**
     * Constructor vacio de la clase.
     */
    public Usuario() {
        
    }

    /**
     * Constructor de la clase con todos los parametros.
     * 
     * @param nombre
     * @param apellidos
     * @param CC
     * @param fechaCreacion
     * @param usuario
     * @param contrasenya 
     */
    public Usuario(String nombre, String apellidos, String CC, Date fechaCreacion, String usuario, String contrasenya) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.CC = CC;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the CC
     */
    public String getCC() {
        return CC;
    }

    /**
     * @param CC the CC to set
     */
    public void setCC(String CC) {
        this.CC = CC;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenya
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * @param contrasenya the contrasenya to set
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    public boolean isAdministrador(){
        return this instanceof Administrador;
    }
    
    public boolean isCliente(){
        return this instanceof Cliente;
    }
    
    public boolean isGerente(){
        return this instanceof Gerente;
    }
}
