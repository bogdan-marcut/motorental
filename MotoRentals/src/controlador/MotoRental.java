package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import modelo.Administrador;
import modelo.Cliente;
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
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Local> listaLocales;
    private ArrayList<Reserva> listaReservas;
    
    public MotoRental(){
        this.listaUsuarios = new ArrayList<>();
        this.listaLocales = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        this.listaUsuarios.add(new Administrador("a1", "Administrador", "admin", "admin"));
    }
    
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

    public void cargarDatos() {
        MotoRentDataManager dataManager = new MotoRentDataManager();
        dataManager.obtenirDades("data/MotoRent.xml");
        this.listaLocales = dataManager.getListaLocales();
        this.listaUsuarios = dataManager.getListaUsuarios();
        this.listaReservas = dataManager.getListaReservas();
    }

    public boolean comprobarCliente(String usuario) {
        boolean existe = false;
        Iterator<Usuario> iterador = this.listaUsuarios.iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.getUsuario().equals(usuario)){
                existe = true;
            }
        }
        return existe;
    }

    public Usuario añadirCliente(String usuario, String contrasenya, String nombre, String apellidos, String CC, String calle, String numero, String codigoPostal, String poblacion) {
        Cliente ci = new Cliente("c" + this.getNumeroClientes(), nombre, apellidos, CC, new Date(), usuario, contrasenya, 0, new Direccion(calle, numero, codigoPostal, poblacion));
        this.listaUsuarios.add(ci);
        return ci;
    }
    
    public int getNumeroClientes(){
        int numeroClientes = 0;
        Iterator<Usuario> iterador = this.listaUsuarios.iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.isCliente()){
                numeroClientes += 1;
            }
        }
        return numeroClientes;
    }

    public Usuario getUsuario(String usuario, String contrasenya) {
        Usuario us = null;
        Iterator<Usuario> iterador = this.listaUsuarios.iterator();
        while(iterador.hasNext()){
            Usuario u = iterador.next();
            if(u.getUsuario().equals(usuario) && u.getContrasenya().equals(contrasenya)){
                us = u;
            }
        }  
        return us;
    }
}