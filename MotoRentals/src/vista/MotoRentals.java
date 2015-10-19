package vista;

import java.util.Date;
import java.util.Scanner;

/**
 * Clase de menu del programa.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRentals {
    
    private String usuario;         //usuario test:     admin
    private String contraseña;      //contraseña test:  pass
    private int privilegio;

    public MotoRentals() {
        this.usuario = "";
        this.contraseña = "";
        this.privilegio = 0;
    }
    
    public void loguearse() {
        int opcion;
        String user;
        String pass;
        do {
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("1. Registrarse");
            this.escriu("2. Loguearse");
            
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("Introduzca el nombre de usuario: ");
                    this.usuario = this.llegeixString();
                    this.escriu("Introduzca la contraseña: ");
                    this.contraseña = this.llegeixString();
                    this.escriu("TEST: Elige el tipo de usuaio (1-cliente, 2-gerente, 3-propietario):");
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
        this.escriu("************************************");
        } while(opcion != 2);
        
        
    }
    /**
     * Es la pagina principal del menu
     * 
     */
    public void gestionVista() {
        int opcion;
        
        this.loguearse();
        do {
            this.escriu("");
            this.escriu("*************** Menu ***************");
            this.escriu("0. Salir");
            this.escriu("1. Actualizar Datos");
            this.escriu("2. Solicitar Reserva Moto");
            this.escriu("3. Darse de Baja");
            if(this.privilegio == 2) {
                this.escriu("4. Comprobar Reserva Moto");
                this.escriu("5. Solicitar Motos");
                this.escriu("6. Actualizar Estado Motos");
            }
            else if(this.privilegio == 3) {
                this.escriu("4. Guardar Informacion Cliente");
                this.escriu("5. Rellenar Local");
                this.escriu("6. Informe del Mes");
                this.escriu("7. Gestionar Motos");
            }
            
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
                    this.loguearse();
                    break;
                    
                case 4:
                    if(this.privilegio == 2){
                        this.gestionarReservas();
                    }
                    else if(this.privilegio == 3){
                        this.escriu("La accion se ha realizado corectamente");
                    }
                    break;
                    
                case 5:
                    if(this.privilegio == 2){
                        this.escriu("La accion se ha realizado corectamente");
                    }
                    else if(this.privilegio == 3){
                        this.escriu("La accion se ha realizado corectamente");
                    }
                    break;
                    
                case 6:
                    if(this.privilegio == 2){
                        this.escriu("La accion se ha realizado corectamente");
                    }
                    else if(this.privilegio == 3){
                        this.escriu("La accion se ha realizado corectamente");
                    }
                    break;
                    
                case 7:
                    if(this.privilegio == 3){
                        this.gestionarMotos();
                    }
                    break;
            }
        escriu("************************************");
        
        } while(opcion != 0);
    }
    
    public void gestionarReservas(){
        int opcion;
        do{
            this.escriu("*************** Menu ***************");
            this.escriu("0. Volver");
            this.escriu("1. Proporcionar Moto");
            this.escriu("2. Reservar Moto");
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
        } while(opcion != 0);
    }
    
    public void gestionarMotos(){
        int opcion;
        do{
            this.escriu("*************** Menu ***************");
            this.escriu("0. Volver");
            this.escriu("1. Dar de Alta Moto");
            this.escriu("2. Dar de Baja Moto");
            opcion = solicitarOpcion(); 
            switch(opcion) {
                case 1:
                    this.escriu("La accion se ha realizado corectamente");
                    break;

                case 2:
                    this.escriu("La accion se ha realizado corectamente");
                    break;
            }
        } while(opcion != 0);
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
    
    
    public void escriu(String s){
        System.out.println(s);
    }
    
    public void escriu(int i){
        System.out.println(i);
    }
    
    public void escriu(float f){
        System.out.println(f);
    }
    
    public void escriu(Date d){
        System.out.println(d);
    }
    
    public int llegeixInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public String llegeixString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    
    public Date LlegeixDataSistema(){
        return new Date();
    }
}