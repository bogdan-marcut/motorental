package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import modelo.Cliente;
import modelo.Datos;
import modelo.Direccion;
import modelo.Local;
import modelo.Reserva;
import modelo.Usuario;

/**
 * Clase controladora.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRental {
    
    private Datos datos;
    
    /**
     * Constructor por defecto de la clase.
     */
    public MotoRental(){
        datos = new Datos();
    }

    /**
     * @return the datos
     */
    public Datos getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Datos datos) {
        this.datos = datos;
    }
    
    /**
     * Devuelve el tipo de usuario que pasamos por parametro.
     * Los usuarios pueden ser: administrador, gerente, cliente o anonimo.
     * 
     * @param usuario
     * @return String
     */
    public String tipoUsuario(Usuario usuario){
        if(usuario.isAdministrador()){
            return "administrador";
        }
        if(usuario.isCliente()){
            return "cliente";
        }
        if(usuario.isGerente()){
            return "gerente";
        }
        return "anonimo";
    }

    /**
     * Carga los datos contenidos del xml en el sistema.
     */
    public void cargarDatos() {
        MotoRentDataManager dataManager = new MotoRentDataManager();
        dataManager.obtenirDades("data/MotoRent.xml");
        datos.setListaLocales(dataManager.getListaLocales());
        datos.setListaUsuarios(dataManager.getListaUsuarios());
        datos.setListaReservas(dataManager.getListaReservas());
    }

    /**
     * Devuelve un booleano indicando si un nombre de usuario esta disponible.
     * 
     * @param usuario
     * @return boolean
     */
    public boolean comprobarCliente(String usuario) {
        boolean existe = false;
        Iterator<Usuario> iterador = datos.getListaUsuarios().iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.getUsuario().equals(usuario)){
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Añade un nuevo usuario al sistema.
     * 
     * @param usuario
     * @param contrasenya
     * @param nombre
     * @param apellidos
     * @param CC
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param poblacion
     * @return Usuario
     */
    public Usuario añadirCliente(String usuario, String contrasenya, String nombre, String apellidos, String CC, String calle, String numero, String codigoPostal, String poblacion) {
        Cliente ci = new Cliente("c" + this.getNumeroClientes(), nombre, apellidos, CC, new Date(), usuario, contrasenya, 0, new Direccion(calle, numero, codigoPostal, poblacion));
        datos.getListaUsuarios().add(ci);
        return ci;
    }
    
    /**
     * Devuelve la cantidad de clientes dentro del conjunto de usuarios guardados
     * en el sistema.
     * 
     * @return int
     */
    public int getNumeroClientes(){
        int numeroClientes = 0;
        Iterator<Usuario> iterador = datos.getListaUsuarios().iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.isCliente()){
                numeroClientes += 1;
            }
        }
        return numeroClientes;
    }

    /**
     * Devuelve un usuario segun su nombre de usuario y contraseña. Si el usuario
     * no existe devuelve null.
     * 
     * @param usuario
     * @param contrasenya
     * @return Usuario
     */
    public Usuario getUsuario(String usuario, String contrasenya) {
        Usuario us = null;
        Iterator<Usuario> iterador = datos.getListaUsuarios().iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.getUsuario().equals(usuario) && u.getContrasenya().equals(contrasenya)){
                us = u;
            }
        }  
        return us;
    }
    
    /**
     * Devuelve un booleano indicando si el usuario ya dispone de una reserva 
     * posterior a la fecha introducida.
     * 
     * @param idCliente
     * @param fechaEntrega
     * @return boolean
     */
    public boolean comprobarReserva(String idCliente, Date fechaEntrega) {
        boolean noTieneReserva = true;
        for (Reserva ri : datos.getListaReservas()) {
            if (ri.getId().equals(idCliente) && ri.getFechaRecogida().before(fechaEntrega)) {
                noTieneReserva = false;
            }
        }
        return noTieneReserva;
    }
    
    
    /**
     * Devuelve un String con los locales que tienen motos disponibles.
     * 
     * @return String
     */
    public String mostrarLocalesConMotos() {
        String s = "--- Locales con Motos Disponibles ---\n";
        for (Local li : datos.getListaLocales()) {
            if (li.getMotosDisponibles() > 0) {
                s += li + "\n";
            }
        }
        return s;
    }
    
    public void entregarMoto(String idReserva, Local local){
        local.entregarMoto(idReserva);
    }
    
    /**
     * Devuelve un objeto Date dado un formato y un String.
     * 
     * @param format
     * @param sDate
     * @return Date
     * @throws ParseException 
     */
    public Date stringToDate(String format, String sDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        Date date = formatter.parse(sDate);
        return date;
    }
}