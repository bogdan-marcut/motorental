package vista;

/**
 * Clase de menu del programa.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRentals {

    public MotoRentals() {
    }

    
    
    public void loguearse() {
        String usuario;
        String contraseña;
        do {
            escriu("Usuario: ");
            usuario = llegeixString();
            escriu("Contraseña: ");
            contraseña = llegeixString();
            
        }
    }
    /**
     * Es la pagina principal del menu
     * 
     */
    public void gestionVista() {
        int opcion;
        
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
            
        if(user instanceof Gerente) {
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
        if(user instanceof Propietario) {
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
        option = llegeixInt();
        escriu("");
        return opcion;
    }
}