package modelo;

import java.util.Date;

/**
 * Clase pagament.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Pagament {
   
    private double tarifa_x_hora;
    private double horas;
    private double descuento;
    private double penalizacion;
    private double total;

    /**
     * Constuctor de la clase vacio.
     */
    public Pagament(){
    }
    
    /** 
     * Constructor de la clase.
     * 
     * @param tarifa_x_hora
     * @param horas
     * @param descuento
     * @param penalizacion
     * @param total 
     */
    public Pagament(double tarifa_x_hora, double horas, double descuento, double penalizacion, double total) {
        this.tarifa_x_hora = tarifa_x_hora;
        this.horas = horas;
        this.descuento = descuento;
        this.penalizacion = penalizacion;
        this.total = total;
    }
    
    /**
     * @return the tarifa_x_hora
     */
    public double getTarifa_x_hora() {
        return tarifa_x_hora;
    }

    /**
     * @param tarifa_x_hora the tarifa_x_hora to set
     */
    public void setTarifa_x_hora(double tarifa_x_hora) {
        this.tarifa_x_hora = tarifa_x_hora;
    }

    /**
     * @return the horas
     */
    public double getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(double horas) {
        this.horas = horas;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
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
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    public void iniciarPago(Date fechaRecogida, Date fechaDevolucion){
        int dias = fechaDevolucion.getDay()- fechaRecogida.getDay();
        int horas = fechaDevolucion.getHours()- fechaRecogida.getHours();
        this.horas = dias * 24 + horas;
        System.out.println(dias);
    }
    
    @Override
    public String toString() {
        String s = "Tarifa por hora: " + tarifa_x_hora + "\n";
        s += "Horas: " + horas + "\n";
        s += "Descuento: " + descuento + "\n";
        s += "Penalizacion: " + penalizacion + "\n";
        s += "Total: " + total + "\n";
        
        return s;
    }
}
