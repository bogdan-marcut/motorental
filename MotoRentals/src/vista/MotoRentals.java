package vista;

import controlador.MotoRental;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import modelo.Local;
import modelo.Usuario;

/**
 * Clase de menu del programa.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRentals {
    
    private MotoRental control;
    Usuario user;

    /**
     * Constructor del menu.
     * Puede haber solamente un usuario de momento.
     *
     * usuario: el nombre de usuario
     * contraseña: la contraseña del usuario
     * privilegio: el tipo de usuario (Cliente, Gerente, Propietario o Administrador)
     */
    public MotoRentals() {
        this.control = new MotoRental();
    }
    
    /**
     * Es la pagina principal del menu.
     * 
     */
    public void gestionVista() {
        int opcion;
        String usuario = "";
        String contrasenya;
        String nombre;
        String apellidos;
        String CC;
        String calle;
        String numero;
        String codigoPostal;
        String poblacion;
        String privilegio = "anonimo";
        Usuario us;
        
        do {
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("1. Registrarse");
            this.escriu("2. Logarse");
            this.escriu("3. Salir");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("Introduzca el nombre de usuario: ");
                    while(usuario.equals("")){
                        usuario = this.llegeixString();
                        if(this.control.comprobarCliente(usuario)){
                            usuario = "";
                            this.escriu("\n(!) El usuario ya existe! Intentalo de nuevo: ");
                        }
                    }
                    
                    this.escriu("Introduzca la contraseña: ");
                    contrasenya = this.llegeixString();
                    
                    this.escriu("Introduzca su nombre: ");
                    nombre = this.llegeixString();
                    
                    this.escriu("Introduzca sus apellidos: ");
                    apellidos = this.llegeixString();
                    
                    this.escriu("Introduzca su cuenta bancaria: ");
                    CC = this.llegeixString();
                    
                    this.escriu("Introduzca su calle: ");
                    calle = this.llegeixString();
                    
                    this.escriu("Introduzca el numero: ");
                    numero = this.llegeixString();
                    
                    this.escriu("Introduzca el codigo postal: ");
                    codigoPostal = this.llegeixString();
                    
                    this.escriu("Introduzca la poblacion: ");
                    poblacion = this.llegeixString();
                    
                    us = this.control.añadirCliente(usuario, contrasenya, nombre, apellidos, CC, calle, numero, codigoPostal, poblacion);
                    privilegio = this.control.tipoUsuario(us);
                    break;

                case 2:
                    do {
                        this.escriu("Usuario: ");
                        usuario = llegeixString();
                        this.escriu("Contraseña: ");
                        contrasenya = llegeixString();
                        try {
                            user = this.control.getUsuario(usuario, contrasenya);  
                            privilegio = this.control.tipoUsuario(user);
                        } catch(Exception ex){
                            System.err.println("Datos incorrectos!");
                        }
                    }
                    while(privilegio.equals("anonimo"));
                    break;
            }
            if(opcion == 2){
                switch (privilegio) {
                    case "cliente":
                        this.menuCliente();
                        break;
                    case "gerente":
                        this.menuGerente();
                        break;
                    case "administrador":
                        this.menuAdministrador();
                        break;
                    default:
                }
            }
            
        this.escriu("************************************");
        } while(opcion != 3);

    }

    /**
     * Es el menu del los usuarios que tienen privilegio de Cliente.
     * 
     */
    public void menuCliente() {
        int opcion;
        do {
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("1. Solicitar Reserva Moto");
            this.escriu("2. Actualizar Datos");
            this.escriu("3. Darse de Baja");
            this.escriu("4. Log Out");
            
            opcion = solicitarOpcion();
            switch(opcion) {
                case 1:
                    String format = "yyyy-MM-dd HH:mm:ss";
                    this.escriu("Introduce la fecha de recogida:");
                    this.escriu("Formato de la fecha: " + format);
                    String sRecogida = this.llegeixString();
                    this.escriu("Introduce la fecha de devolucion:");
                    this.escriu("Formato de la fecha: " + format);
                    String sDevolucion = this.llegeixString();
                    try {
                        Date fechaRegogida = control.stringToDate(format, sRecogida);
                        this.escriu(fechaRegogida);
                        Date fechaDevolucion = control.stringToDate(format, sDevolucion);
                        if (control.comprobarReserva(user.getId(), fechaRegogida)) {
                            this.escriu(control.mostrarLocalesConMotos());
                            this.escriu("Introduce el id del local de origen:");
                            String idOrigen = this.llegeixString();
                            this.escriu(control.mostrarLocales());
                            this.escriu("Introduce el id del local de destino:");
                            String idDestino = this.llegeixString();
                        }
                    } catch(ParseException ex) {
                        this.escriu("\t(!) Error en el formato de la fecha.");
                    }
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 3:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
            this.escriu("************************************");
        } while(opcion != 4 && opcion != 3);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Gerente.
     * 
     */
    public void menuGerente(){
        int opcion;
        do {
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("1. Comprobar Reserva Moto");
            this.escriu("2. Solicitar Motos");
            this.escriu("3. Actualizar Estado Motos");
            this.escriu("4. Log Out");
             
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.gestionarReservas();
                    break;
                    
                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 3:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
            this.escriu("************************************");
        } while(opcion != 4);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Administrador.
     * 
     */
    public void menuAdministrador(){
        int opcion;
        do {
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("1. Gestionar Gerentes");
            this.escriu("2. Gestionar Locales");
            this.escriu("3. Cargar Datos");
            this.escriu("4. Log Out");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.gestionarGerentes();
                    break;
                    
                case 2:
                    this.gestionarLocales();
                    break;
                    
                case 3:
                    this.control.cargarDatos();
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
            this.escriu("************************************");
        } while(opcion != 4);
    }
    
    /**
     * Es el submenu del Gerente para gestionar las reservas.
     * 
     */
    public void gestionarReservas(){
        int opcion;
        do{
            this.escriu("*************** Menu ***************");
            this.escriu("1. Entregar Moto");
            this.escriu("2. Devolver Moto");
            this.escriu("3. Volver");
            
            
            opcion = solicitarOpcion();
            
            this.escriu("Id Reserva: ");
            String idReserva = this.llegeixString();
            this.escriu("Id Local: ");
            String idLocal = this.llegeixString();
            
            switch(opcion) {
                case 1:
                    for(Local li:control.getDatos().getListaLocales()){
                        if(li.checkLocal(idLocal)){
                            this.control.entregarMoto(idReserva,li);
                        }
                    }
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
        } while(opcion != 3);
    }
    
    /**
     * Es el submenu del Administrador que añade o quita Gerentes.
     */
    public void gestionarGerentes(){
        int opcion;
        do{
            this.escriu("*************** Menu ***************");
            this.escriu("1. Dar de Alta Gerente");
            this.escriu("2. Dar de Baja Gerente");
            this.escriu("3. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
        } while(opcion != 3);
    }
    
    /**
     * Es el submenu del Administrador que añade o quita locales.
     * 
     */
    public void gestionarLocales(){
        int opcion;
        do{
            this.escriu("*************** Menu ***************");
            this.escriu("1. Dar de Alta Local");
            this.escriu("2. Dar de Baja Local");
            this.escriu("3. Gestionar Motos");
            this.escriu("4. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
                
                case 3:
                    this.gestionarMotos();
                    break;
            }
        } while(opcion != 4);
    }
        
    /**
     * Es el submenu del Administrador que añade o quita motos.
     */
    public void gestionarMotos(){
        int opcion;
        do{
            this.escriu("*************** Menu ***************");
            this.escriu("1. Dar de Alta Moto");
            this.escriu("2. Dar de Baja Moto");
            this.escriu("3. Volver");
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
        } while(opcion != 3);
    }
    
    /**
     * Devuelve una opcion seleccionada por el usuario.
     *
     * @return int
     */
    public int solicitarOpcion() {
        this.escriu("\n>> Escoge una opcion: ");
        int opcion;
        opcion = llegeixInt();
        this.escriu("");
        return opcion;
    }
    
    /**
     * Escribe por pantalla un string.
     * 
     * @param s String a imprimir
     */
    public void escriu(String s){
        System.out.println(s);
    }
    
    /**
     * Escribe por pantalla un int.
     * 
     * @param i int a imprimir
     */
    public void escriu(int i){
        System.out.println(i);
    }
    
    /**
     * Escribe por pantalla un float.
     * 
     * @param f float a imprimir
     */
    public void escriu(float f){
        System.out.println(f);
    }
    
    /**
     * Escribe por pantalla una data.
     * 
     * @param d Date a imprimir 
     */
    public void escriu(Date d){
        System.out.println(d);
    }
    
    /**
     * Lee un int y lo devuelve.
     * 
     * @return int
     */
    public int llegeixInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    /**
     * Lee un string y lo devuelve.
     * 
     * @return String
     */
    public String llegeixString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    /**
     * Lee la data del sistema y lo devuelve.
     * 
     * @return Date
     */
    public Date llegeixDataSistema(){
        return new Date();
    }
    
}
