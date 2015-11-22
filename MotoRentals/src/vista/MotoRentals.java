package vista;

import java.util.Date;
import java.util.Scanner;

/**
 * Clase de menu del programa.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRentals {
    
    private String usuario;
    private String contraseña;
    private int privilegio;

    /**
     * Constructor del menu.
     * Puede haber solamente un usuario de momento.
     *
     * usuario: el nombre de usuario
     * contraseña: la contraseña del usuario
     * privilegio: el tipo de usuario (Cliente, Gerente, Propietario o Administrador)
     */
    public MotoRentals() {
        this.usuario = "";
        this.contraseña = "";
        this.privilegio = 0;
    }
    
    /**
     * Es la pagina principal del menu.
     * 
     */
    public void gestionVista() {
        int opcion;
        String user;
        String pass;
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
                    this.usuario = this.llegeixString();
                    this.escriu("Introduzca la contraseña: ");
                    this.contraseña = this.llegeixString();
                    this.escriu("TEST: Elige el tipo de usuaio (1-cliente, 2-gerente, 3-propietario, 4-admin):");
                    this.privilegio = this.llegeixInt();
                    break;

                case 2:
                    do {
                        this.escriu("Usuario: ");
                        user = llegeixString();
                        this.escriu("Contraseña: ");
                        pass = llegeixString();
                    }
                    while(!this.usuario.equals(user) && !this.contraseña.equals(pass));
                    break;
            }
            if(opcion == 2){
                switch (this.privilegio) {
                    case 1:
                        this.menuCliente();
                        break;
                    case 2:
                        this.menuGerente();
                        break;
                    case 3:
                        this.menuPropietario();
                        break;
                    case 4:
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
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 3:
                    this.escriu("La accion se ha realizado corectamente");
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
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("1. Guardar Informacion del Cliente");
            this.escriu("2. Rellenar Local");
            this.escriu("3. Ver Informacion de Todos los Locales");
            this.escriu("4. Ver Informe del Mes");
            this.escriu("5. Log Out");
             
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 3:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
                    
                case 4:
                    this.escriu("La accion se ha realizado corectamente");
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
                    this.escriu("La accion se ha realizado corectamente");
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
            this.escriu("*************** Menu ***************");
            this.escriu("1. Proporcionar Moto");
            this.escriu("2. Reservar Moto");
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
        escriu("\n>> Escoge una opcion: ");
        int opcion;
        opcion = llegeixInt();
        escriu("");
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