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
    private int numMotosDisponibles;
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
    public int getNumMotosDisponibles() {
        return numMotosDisponibles;
    }

    /**
     * @param numMotosDisponibles the motosDisponibles to set
     */
    public void setNumMotosDisponibles(int numMotosDisponibles) {
        this.numMotosDisponibles = numMotosDisponibles;
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

    /**
     * Devuleve un booleano indicando si el id enviado por parametro coincide con
     * el id del local actual.
     * 
     * @param id
     * @return boolean
     */
    public boolean checkLocal(String id){
        return this.getID().equals(id);
    }
    
    /**
     * Devuleve un booleano indicando si el id enviado por parametro cumple las
     * condiciones para ser local de origen.
     * 
     * @param idLocalOrigen
     * @return boolean
     */
    public boolean checkLocalOrigen(String idLocalOrigen){
        return (this.getID().equals(idLocalOrigen) && this.getMotos().size() >= 1);
    }
    
    /**
     * Devuleve un booleano indicando si el id enviado por parametro cumple las
     * condiciones para ser local de destino.
     * 
     * @param idLocalDestino
     * @return boolean
     */
    public boolean checkLocalDestino(String idLocalDestino){
        return (this.getID().equals(idLocalDestino) && this.getMotos().size() < this.getCapacidad());
    }
    
    /**
     * Muestra la informacion de un local.
     * 
     * @return String 
     */
    public String mostrarLocal(){
        return this.toString();
    }
    
    /**
     * Devuelve las motos en estado 'd'.
     * 
     * @return ArrayList<Moto> 
     */
    public ArrayList<Moto> getMotosDisponibles() {
        ArrayList<Moto> disponibles = new ArrayList();
        for (Moto mi : motos) {
            if (mi.getEstado() == 'd') {
                disponibles.add(mi);
            }
        }
        return disponibles;
    }
    
    /**
     * Muestra las motos disponibles en un String.
     * 
     * @return String 
     */
    public String mostrarMotosDisponibles() {
        String s = "--- Motos Disponibles ---\n";
        for (Moto mi : getMotosDisponibles()) {
            s += mi + "\n";
        }
        return s;
    }
    
    
    
    /**
     * Muestra las motos en un String.
     * 
     * @return String 
     */
    public String mostrarMotos() {
        String s = "--- Motos ---\n";
        for (Moto mi : getMotos()) {
            s += mi + "\n";
        }
        return s;
    }
    
    /**
     * Selecciona una moto para enviar a otro local y la elimina del actual.
     * 
     * @param idMoto
     * @return 
     */
    public Moto moverMoto(String idMoto){
        Iterator<Moto> iterador = this.getMotos().iterator();
        while(iterador.hasNext()){
            Moto m = iterador.next();
            if(m.getId().equals(idMoto)){
                this.eliminarMoto(m);
                return m;
            }
        }
        return null;
    }
    
    /**
     * Añade una nueva moto al local.
     * 
     * @param moto 
     */
    public void añadirMoto(Moto moto){
        this.getMotos().add(moto);
    }
    
    /**
     * Elimina la moto enviada por parametro del local.
     * 
     * @param moto 
     */
    public void eliminarMoto(Moto moto){
        this.getMotos().remove(moto);
    }
    
    /**
     * Solicita una moto al local.
     * 
     * @param cliente
     * @param idLocalOrigen
     * @param idLocalDestino
     * @param moto
     * @param fechaRecogida
     * @param fechaDevolucion 
     */
    public void solicitarMotoLocal(Cliente cliente, int idLocalOrigen, int idLocalDestino, Moto moto, Date fechaRecogida, Date fechaDevolucion){
        
    }
    
    public void entregarMoto(String idReserva){
        for(Reserva re:reservas){
            Moto moto_reserva = re.obtenerMotoReserva(idReserva);
            if(moto_reserva != null){
                moto_reserva.setEstado('o');
                re.iniciarPago();
                this.motosDisponibles--;
            }
        }
    }
}
