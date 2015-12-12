package vista;

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
            Consola.escriu("");
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Registrarse");
            Consola.escriu("2. Logarse");
            Consola.escriu("3. Salir");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    Consola.escriu("Introduzca el nombre de usuario: ");
                    
                    Consola.escriu("Introduzca la contraseña: ");
                    
                    break;

                case 2:
                    do {
                        Consola.escriu("Usuario: ");
                        user = Consola.llegeixString();
                        Consola.escriu("Contraseña: ");
                        pass = Consola.llegeixString();
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
            
        Consola.escriu("************************************");
        } while(opcion != 3);

    }

    /**
     * Es el menu del los usuarios que tienen privilegio de Cliente.
     * 
     */
    public void menuCliente() {
        int opcion;
        do {
            Consola.escriu("");
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Solicitar Reserva Moto");
            Consola.escriu("2. Actualizar Datos");
            Consola.escriu("3. Darse de Baja");
            Consola.escriu("4. Log Out");
            
            opcion = solicitarOpcion();
            switch(opcion) {
                case 1:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;

                case 3:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
            }
            Consola.escriu("************************************");
        } while(opcion != 4 && opcion != 3);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Gerente.
     * 
     */
    public void menuGerente(){
        int opcion;
        do {
            Consola.escriu("");
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Comprobar Reserva Moto");
            Consola.escriu("2. Solicitar Motos");
            Consola.escriu("3. Actualizar Estado Motos");
            Consola.escriu("4. Log Out");
             
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.gestionarReservas();
                    break;
                    
                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 3:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
            }
            Consola.escriu("************************************");
        } while(opcion != 4);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Propietario.
     * 
     */
    public void menuPropietario(){
        int opcion;
        do {
            Consola.escriu("");
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Guardar Informacion del Cliente");
            Consola.escriu("2. Rellenar Local");
            Consola.escriu("3. Ver Informacion de Todos los Locales");
            Consola.escriu("4. Ver Informe del Mes");
            Consola.escriu("5. Log Out");
             
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 3:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 4:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
            }
            Consola.escriu("************************************");
        } while(opcion != 5);
    }
    
    /**
     * Es el menu del los usuarios que tienen privilegio de Administrador.
     * 
     */
    public void menuAdministrador(){
        int opcion;
        do {
            Consola.escriu("");
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Gestionar Gerentes");
            Consola.escriu("2. Gestionar Locales");
            Consola.escriu("3. Cargar Datos");
            Consola.escriu("4. Log Out");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.gestionarGerentes();
                    break;
                    
                case 2:
                    this.gestionarLocales();
                    break;
                    
                case 3:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;
            }
            Consola.escriu("************************************");
        } while(opcion != 4);
    }
    
    /**
     * Es el submenu del Gerente para gestionar las reservas.
     * 
     */
    public void gestionarReservas(){
        int opcion;
        do{
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Proporcionar Moto");
            Consola.escriu("2. Reservar Moto");
            Consola.escriu("3. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
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
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Dar de Alta Gerente");
            Consola.escriu("2. Dar de Baja Gerente");
            Consola.escriu("3. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
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
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Dar de Alta Local");
            Consola.escriu("2. Dar de Baja Local");
            Consola.escriu("3. Gestionar Motos");
            Consola.escriu("4. Volver");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
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
            Consola.escriu("*************** Menu ***************");
            Consola.escriu("1. Dar de Alta Moto");
            Consola.escriu("2. Dar de Baja Moto");
            Consola.escriu("3. Volver");
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    Consola.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    Consola.escriu("La accion se ha realizado corectamente");
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
        Consola.escriu("\n>> Escoge una opcion: ");
        int opcion;
        opcion = Consola.llegeixInt();
        Consola.escriu("");
        return opcion;
    }
    
    /* -------------------------------------------------------------------
     * Metodos que tambien se encuentran en la clase Consola. Los mantenemos
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