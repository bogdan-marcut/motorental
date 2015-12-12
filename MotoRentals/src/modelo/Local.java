package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Clase local.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Local {
    
    private String ID;
    private int capacidad;
    private Gerente gestor;
    private int motosDisponibles;
    private ArrayList<Moto> motos;
    private Direccion direccion;
    private ArrayList<Reserva> reservas;

    public Local() {

    }
    
    public Local(String ID, int capacidad, Gerente gestor, ArrayList<Moto> motos, Direccion direccion, ArrayList<Reserva> reservas) {
        this.ID = ID;
        this.capacidad = capacidad;
        this.gestor = gestor;
        this.motos = motos;
        this.direccion = direccion;
        this.reservas = reservas;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the motosDisponibles
     */
    public int getMotosDisponibles() {
        return motosDisponibles;
    }

    /**
     * @param motosDisponibles the motosDisponibles to set
     */
    public void setMotosDisponibles(int motosDisponibles) {
        this.motosDisponibles = motosDisponibles;
    }

    /**
     * @return the motos
     */
    public ArrayList<Moto> getMotos() {
        return motos;
    }

    /**
     * @param motos the motos to set
     */
    public void setMotos(ArrayList<Moto> motos) {
        this.motos = motos;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the reservas
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * @return the gestor
     */
    public Gerente getGestor() {
        return gestor;
    }

    /**
     * @param gestor the gestor to set
     */
    public void setGestor(Gerente gestor) {
        this.gestor = gestor;
    }

    public boolean checkLocal(String id){
        return this.ID.equals(id);
    }
    
    public boolean checkLocalOrigen(String idLocalOrigen){
        return (this.ID.equals(idLocalOrigen) && this.motos.size() >= 1);
    }
    
    public boolean checkLocalDestino(String idLocalDestino){
        return (this.ID.equals(idLocalDestino) && this.motos.size() < this.capacidad);
    }
    
    public Local mostrarLocal(){
        return this;
    }
    
    public ArrayList<Moto> mostrarMotos(){
        return this.motos;
    }
    
    //se tiene que modificar
    public ArrayList<Moto> mostrarMotosDisponibles(Date fechaRecogida, Date fechaDevolucion){
        ArrayList<Moto> motos = null;
        Iterator<Reserva> iterador = this.reservas.iterator();
        while(iterador.hasNext()){
            Reserva r = iterador.next();
        }
        return motos;
    }
    
    public Moto moverMoto(String idMoto){
        Iterator<Moto> iterador = this.motos.iterator();
        while(iterador.hasNext()){
            Moto m = iterador.next();
            if(m.getId().equals(idMoto)){
                this.eliminarMoto(m);
                return m;
            }
        }
        return null;
    }
    
    public void añadirMoto(Moto moto){
        this.motos.add(moto);
    }
    
    public void eliminarMoto(Moto moto){
        this.motos.remove(moto);
    }
    
    public void solicitarMotoLocal(Cliente cliente, int idLocalOrigen, int idLocalDestino, Moto moto, Date fechaRecogida, Date fechaDevolucion){
        
    }
}
