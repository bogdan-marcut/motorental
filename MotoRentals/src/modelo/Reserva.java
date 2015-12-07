package modelo;

import java.util.Date;

/**
 * Clase reserva.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Reserva {
    
    private int id;
    private Date fechaRecogida;
    private Date fechaDevolucion;
    private double penalizacion;
    
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
     */
    public Reserva(int id, Date fechaRecogida, Date fechaDevolucion, double penalizacion) {
        this.id = id;
        this.fechaRecogida = fechaRecogida;
        this.fechaDevolucion = fechaDevolucion;
        this.penalizacion = penalizacion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
    
    
}
