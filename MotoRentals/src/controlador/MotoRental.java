package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import modelo.Administrador;
import modelo.Local;
import modelo.Usuario;

/**
 * Clase controladora.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class MotoRental {
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Local> listaLocales;
    
    public MotoRental(){
        this.listaUsuarios = new ArrayList<Usuario>();
        this.listaLocales = new ArrayList<Local>();
        this.listaUsuarios.add(new Administrador("a1", "Administrador", "admin", "admin"));
    }
    
    public String tipoUsuario(String user, String pass){
        Iterator<Usuario> iterador = this.listaUsuarios.iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.getUsuario().equals(user) && u.getContrasenya().equals(pass)){
                if(u.isAdministrador()){
                   return "administrador";
                }
                if(u.isCliente()){
                    return "cliente";
                }
                if(u.isGerente()){
                    return "gerente";
                }
            }
        }
        return "anonimo";
    }
}
