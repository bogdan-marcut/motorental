package modelo;

import java.util.ArrayList;

/**
 * Clase con los datos del programa.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Datos {
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Local> listaLocales;
    private ArrayList<Reserva> listaReservas;
    
    /**
     * Constructor por defecto de la clase.
     */
    public Datos() {
        this.listaUsuarios = new ArrayList<>();
        this.listaLocales = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        this.listaUsuarios.add(new Administrador("a1", "Administrador", "admin", "admin"));
    }

    /**
     * @return the listaUsuarios
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @return the listaLocales
     */
    public ArrayList<Local> getListaLocales() {
        return listaLocales;
    }

    /**
     * @param listaLocales the listaLocales to set
     */
    public void setListaLocales(ArrayList<Local> listaLocales) {
        this.listaLocales = listaLocales;
    }

    /**
     * @return the listaReservas
     */
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * @param listaReservas the listaReservas to set
     */
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
}
