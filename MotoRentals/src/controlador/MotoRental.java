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
     * Devuelve un String con todos los locales.
     * 
     * @return String
     */
    public String mostrarLocales() {
        String s = "--- Locales ---\n";
        for (Local li : datos.getListaLocales()) {
            s += li + "\n";
        }
        return s;
    }
    
    
    /**
     * Devuelve un String con los locales que tienen motos disponibles.
     * 
     * @return String
     */
    public String mostrarLocalesConMotos() {
        String s = "--- Locales con Motos Disponibles ---\n";
        for (Local li : datos.getListaLocales()) {
            if (li.getNumMotosDisponibles() > 0) {
                s += li + "\n";
            }
        }
        return s;
    }
    
    /**
     * Llama al metodo entregarMoto del local pasado por parametro
     * y le pasa el id de la reserva.
     * 
     * @param idReserva
     * @param local 
     */
    public void entregarMoto(String idReserva, Local local){
        local.entregarMoto(idReserva);
    }
    
    /**
     * Llama al metodo devolverMoto del local pasado por parametro y
     * le pasa el estado de la moto, el coste de reparacion y la fecha.
     * 
     * @param idReserva
     * @param local
     * @param estadoMoto
     * @param costReparacio
     * @param fecha 
     */
    public void devolverMoto(String idReserva, Local local, char estadoMoto, double costReparacio, Date fecha){
        local.devolverMoto(idReserva, estadoMoto, costReparacio, fecha);
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

    /**
     * Devuelve un booleano indicando si los locales seleccionados son aptos.
     * 
     * @param idOrigen
     * @param idDestino
     * @return boolean
     */
    public boolean comprobarOrigenDestino(String idOrigen, String idDestino) {
        boolean esLocalOrigen = false;
        boolean esLocalDestino = false;
        for (Local li : datos.getListaLocales()) {
            if (li.checkLocalOrigen(idOrigen)) esLocalOrigen = true;
            if (li.checkLocalDestino(idDestino)) esLocalDestino = true;
        }
        return esLocalOrigen && esLocalDestino;
    }

    /**
     * Devuelve un String con todas las motos disponibles en el local de origen
     * enviado por parametro.
     * 
     * @param idOrigen
     * @return 
     */
    public String mostrarMotosDisponibles(String idOrigen) {
       String s = "--- Motos Disponibles ---\n";
       for (Local li : datos.getListaLocales()) {
           if (li.checkLocal(idOrigen)) {
               s += li.mostrarMotosDisponibles();
           }
       }
       return s;
    }

    /**
     * Solicita una moto y en caso de que todo sea correcto realiza una reserva.
     * 
     * @param fechaRegogida
     * @param fechaDevolucion
     * @param idOrigen
     * @param idDestino
     * @param idMoto 
     */
    public void solicitarMoto(Date fechaRegogida, Date fechaDevolucion, String idOrigen, String idDestino, String idMoto) {
        
    }
    
    /**
     * Devuelve un string con todas las motos por cada local.
     * 
     * @return String
     */
    public String verMotos(){
        String s = "--- Locales ---\n";
        for(Local li:this.datos.getListaLocales()){
            s += li + "\n";
            s += li.mostrarMotos();
        }
        return s;
    }
}
