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
        do {
            escriu("Usuario: ");
            this.usuario = llegeixString();
            escriu("Contraseña: ");
            this.contraseña = llegeixString();
        }
        while(!this.usuario.equals("admin") && !this.contraseña.equals("pass"));
        this.escriu("TEST: Elige el tipo de usuaio (1-cliente, 2-gerente, 3-propietario):");
        this.privilegio = this.llegeixInt();
    }
    /**
     * Es la pagina principal del menu
     * 
     */
    public void gestionVista() {
        int opcion;
        
        this.loguearse();
        do {
            escriu("");
            escriu("*************** Menu ***************");
            escriu("0. Salir");
            escriu("1. Actualizar Datos");
            escriu("2. Solicitar Reserva Moto");
            escriu("3. Darse de Baja");
            
            opcion = solicitarOpcion();
                
            switch(opcion) {
                case 1:
                    
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;
            }
        
        //if(user instanceof Gerente) en el caso que el programa es completo
        if(this.privilegio == 1) {
            escriu("5. Comprobar Reserva Moto");
            escriu("6. Solicitar Motos");
            escriu("7. Actualizar Estado Motos");
            
            switch(opcion){
                case 5:
                    
                    break;
                    
                case 6:
                    
                    break;
                    
                case 7:
                    
                    break;
            }
        }
        
        //if(user instanceof Propietario) en el caso que el programa es completo
        if(this.privilegio == 2) {
            escriu("5. Guardar Informacion Cliente");
            escriu("6. Rellenar Local");
            escriu("7. Informe del Mes");
            escriu("8. Gestionar Motos");
            
            switch(opcion){
                case 5:
                    
                    break;
                    
                case 6:
                    
                    break;
                    
                case 7:
                    
                    break;
                    
                case 8:
                    
                    break;
            }
        }

        escriu("************************************");
        
        } while (opcion != 0);
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