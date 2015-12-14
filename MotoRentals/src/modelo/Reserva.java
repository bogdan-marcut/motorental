package modelo;

import java.util.Date;

/**
 * Clase reserva.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Reserva {
    
    private String id;
    private Date fechaRecogida;
    private Date fechaDevolucion;
    private double penalizacion;
    private Local localOrigen;
    private Local localDestino;
    private Moto moto;
    private Pagament pagament;
    
    /**
     * Constructor de la clase vacio.
     */
    public Reserva(){
    }

    /**
     * Constructor de la clase.
     * 
     * @param id
     * @param fechaRecogida
     * @param fechaDevolucion
     * @param penalizacion 
     * @param localOrigen 
     * @param localDestino 
     * @param moto 
     * @param pagament 
     */
    public Reserva(String id, Date fechaRecogida, Date fechaDevolucion, double penalizacion, Local localOrigen, Local localDestino, Moto moto, Pagament pagament) {
        this.id = id;
        this.fechaRecogida = fechaRecogida;
        this.fechaDevolucion = fechaDevolucion;
        this.penalizacion = penalizacion;
        this.localOrigen = localOrigen;
        this.localDestino = localDestino;
        this.moto = moto;
        this.pagament = pagament;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fechaRecogida
     */
    public Date getFechaRecogida() {
        return fechaRecogida;
    }

    /**
     * @param fechaRecogida the fechaRecogida to set
     */
    public void setFechaRecogida(Date fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    /**
     * @return the fechaDevolucion
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the penalizacion
     */
    public double getPenalizacion() {
        return penalizacion;
    }

    /**
     * @param penalizacion the penalizacion to set
     */
    public void setPenalizacion(double penalizacion) {
        this.penalizacion = penalizacion;
    }

    /**
     * @return the localDestino
     */
    public Local getLocalDestino() {
        return localDestino;
    }

    /**
     * @param localDestino the localDestino to set
     */
    public void setLocalDestino(Local localDestino) {
        this.localDestino = localDestino;
    }

    /**
     * @return the localOrigen
     */
    public Local getLocalOrigen() {
        return localOrigen;
    }

    /**
     * @param localOrigen the localOrigen to set
     */
    public void setLocalOrigen(Local localOrigen) {
        this.localOrigen = localOrigen;
    }

    /**
     * @return the moto
     */
    public Moto getMoto() {
        return moto;
    }

    /**
     * @param moto the moto to set
     */
    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    /**
     * @return the pagament
     */
    public Pagament getPagament() {
        return pagament;
    }

    /**
     * @param pagament the pagament to set
     */
    public void setPagament(Pagament pagament) {
        this.pagament = pagament;
    }
    
    public Moto obtenerMotoReserva(String idReserva){
        if(this.id.equals(idReserva)) return this.moto;
        else return null;
    }
    
    public void iniciarPago(){
        this.pagament.iniciarPago(this.fechaRecogida,this.fechaDevolucion);
    }
    
    @Override
    public String toString() {
        String s = "Id reserva: " + id + "\n";
        s += "Fecha recogida: " + fechaRecogida + "\n";
        s += "Fecha devolucion: " + fechaDevolucion + "\n";
        s += "Penalizacion: " + penalizacion + "\n";
        s += "Local origen: " + localOrigen + "\n";
        s += "Local destino: " + localDestino + "\n";
        s += "Moto: " + moto + "\n";
        s += "Pagament: " + pagament + "\n";
        return s;
    }
}
