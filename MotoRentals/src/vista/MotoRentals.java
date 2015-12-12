package vista;

import controlador.MotoRentDataManager;
import controlador.MotoRental;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase de menu del programa.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRentals {
    
    private MotoRental control;

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
        String user;
        String pass;
        String privilegio = "anonimo";
        
        do {
            escriu("");
            escriu("*************** Menu ***************");
            escriu("1. Registrarse");
            escriu("2. Logarse");
            escriu("3. Salir");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    escriu("Introduzca el nombre de usuario: ");
                    
                    escriu("Introduzca la contraseña: ");
                    
                    break;

                case 2:
                    do {
                        escriu("Usuario: ");
                        user = llegeixString();
                        escriu("Contraseña: ");
                        pass = llegeixString();
                        privilegio = this.control.tipoUsuario(user, pass);
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
                    case "propietario":
                        this.menuPropietario();
                        break;
                    case "administrador":
                        this.menuAdministrador();
                        break;
                    default:
                }
            }
            
        escriu("************************************");
        } while(opcion != 3);

    }

    /**
     * Es el menu del los usuarios que tienen privilegio de Cliente.
     * 
     */
    public void menuCliente() {
        int opcion;
        do {
            escriu("");
            escriu("*************** Menu ***************");
            escriu("1. Solicitar Reserva Moto");
            escriu("2. Actualizar Datos");
            escriu("3. Darse de Baja");
            escriu("4. Log Out");
            
            opcion = solicitarOpcion();
            switch(opcion) {
                case 1:
                    escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    escriu("La accion se ha realizado corectamente");
                    break;

                case 3:
                    escriu("La accion se ha realizado corectamente");
                    break;
            }
            escriu("************************************");
        } while(opcion != 4 && opcion != 3);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Gerente.
     * 
     */
    public void menuGerente(){
        int opcion;
        do {
            escriu("");
            escriu("*************** Menu ***************");
            escriu("1. Comprobar Reserva Moto");
            escriu("2. Solicitar Motos");
            escriu("3. Actualizar Estado Motos");
            escriu("4. Log Out");
             
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.gestionarReservas();
                    break;
                    
                case 2:
                    escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 3:
                    escriu("La accion se ha realizado corectamente");
                    break;
            }
            escriu("************************************");
        } while(opcion != 4);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Propietario.
     * 
     */
    public void menuPropietario(){
        int opcion;
        do {
            escriu("");
            escriu("*************** Menu ***************");
            escriu("1. Guardar Informacion del Cliente");
            escriu("2. Rellenar Local");
            escriu("3. Ver Informacion de Todos los Locales");
            escriu("4. Ver Informe del Mes");
            escriu("5. Log Out");
             
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 2:
                    escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 3:
                    escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 4:
                    escriu("La accion se ha realizado corectamente");
                    break;
            }
            escriu("************************************");
        } while(opcion != 5);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Administrador.
     * 
     */
    public void menuAdministrador(){
        int opcion;
        do {
            escriu("");
            escriu("*************** Menu ***************");
            escriu("1. Gestionar Gerentes");
            escriu("2. Gestionar Locales");
            escriu("3. Cargar Datos");
            escriu("4. Log Out");
            
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
                    escriu("La accion se ha realizado corectamente");
                    break;
            }
            escriu("************************************");
        } while(opcion != 4);
    }
    
    /**
     * Es el submenu del Gerente para gestionar las reservas.
     * 
     */
    public void gestionarReservas(){
        int opcion;
        do{
            escriu("*************** Menu ***************");
            escriu("1. Proporcionar Moto");
            escriu("2. Reservar Moto");
            escriu("3. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    escriu("La accion se ha realizado corectamente");
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
            escriu("*************** Menu ***************");
            escriu("1. Dar de Alta Gerente");
            escriu("2. Dar de Baja Gerente");
            escriu("3. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    escriu("La accion se ha realizado corectamente");
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
            escriu("*************** Menu ***************");
            escriu("1. Dar de Alta Local");
            escriu("2. Dar de Baja Local");
            escriu("3. Gestionar Motos");
            escriu("4. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    escriu("La accion se ha realizado corectamente");
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
            escriu("*************** Menu ***************");
            escriu("1. Dar de Alta Moto");
            escriu("2. Dar de Baja Moto");
            escriu("3. Volver");
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    escriu("La accion se ha realizado corectamente");
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
        escriu("\n>> Escoge una opcion: ");
        int opcion;
        opcion = llegeixInt();
        escriu("");
        return opcion;
    }
    
    /* -------------------------------------------------------------------
     * Metodos que tambien se encuentran en la clase  Los mantenemos
     * por si mas adelante los queremos volver a utilizar.
     * -------------------------------------------------------------------
     */
    
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
        return sc.next();
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