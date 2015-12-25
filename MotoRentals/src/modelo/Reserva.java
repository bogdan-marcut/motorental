package modelo;

import java.text.SimpleDateFormat;
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
    private Cliente cliente;
    
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
    public Reserva(String id, Date fechaRecogida, Date fechaDevolucion, double penalizacion, Local localOrigen, Local localDestino, Moto moto, Pagament pagament, Cliente cliente) {
        this.id = id;
        this.fechaRecogida = fechaRecogida;
        this.fechaDevolucion = fechaDevolucion;
        this.penalizacion = penalizacion;
        this.localOrigen = localOrigen;
        this.localDestino = localDestino;
        this.moto = moto;
        this.pagament = pagament;
        this.cliente = cliente;
    } 

    /**
     * Constructor de una nueva reserva realizada por un cliente.
     * 
     * @param fechaRecogida
     * @param fechaDevolucion
     * @param localOrigen
     * @param localDestino
     * @param moto
     * @param cliente 
     */
    public Reserva(Date fechaRecogida, Date fechaDevolucion, Local localOrigen, Local localDestino, Moto moto, Cliente cliente) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMYY");
        String sDate = formatter.format(new Date());
        this.id = cliente.getId() + "_" + sDate;
        this.fechaRecogida = fechaRecogida;
        this.fechaDevolucion = fechaDevolucion;
        this.localOrigen = localOrigen;
        this.localDestino = localDestino;
        this.moto = moto;
        this.cliente = cliente;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    
    /**
     * Devuelve la moto de la reserva.
     * 
     * @param idReserva
     * @return Moto
     */
    public Moto obtenerMotoReserva(String idReserva){
        if(this.id.equals(idReserva)) return this.moto;
        else return null;
    }
    
    /**
     * Llama el metodo iniciar pago pasandole las fechas de recogida
     * y devolucion de la moto.
     * 
     */
    public void iniciarPago(){
        this.pagament.iniciarPago(this.fechaRecogida,this.fechaDevolucion);
    }
    
    /**
     * Añade el coste de la reparacion a la penalizacion de la reserva.
     * 
     * @param costeReparacion 
     */
    public void añadirPenalizacion(double costeReparacion){
        Cliente cliente_reserva = this.cliente;
        this.penalizacion += costeReparacion;
        cliente_reserva.apuntarFalta();
        this.pagament.añadirPenalizacion(costeReparacion);
    }
    
    /**
     * Devuelve si se devuelve en la fecha correcta.
     * 
     * @param fecha
     * @return 
     */
    public boolean mirarFechaDevolucion(Date fecha){
        
        if(this.fechaDevolucion.getDay() > fecha.getDay()){
           return true;
        }
        else if(this.fechaDevolucion.getDay() == fecha.getDay() 
                && this.fechaDevolucion.getHours() >= fecha.getHours()){
            return true;
        }
        return false;
    }
    
    /**
     * Devuelve un boolean indicando si la reserva en la que nos encontramos
     * perteece al mes enviado por parametro.
     * 
     * @param mes
     * @return boolean
     */
    public boolean mostrarReservasClienteDelMes(Date mes) {
        return (mes.getMonth() == fechaDevolucion.getMonth());
    }
    
    /**
     * Llama al metodo de añadir coste del pago y actualiza la 
     * fecha de devolucion.
     * 
     * @param fecha 
     */
    public void añadirRetraso(Date fecha){
        this.pagament.añadirCosteRetraso(fecha,this.fechaDevolucion);
        this.fechaDevolucion = fecha;
    }
    
    @Override
    public String toString() {
        String s = "Id reserva: " + id + "\n";
        s += "Cliente: " + cliente + "\n";        
        s += "Fecha recogida: " + fechaRecogida + "\n";
        s += "Fecha devolucion: " + fechaDevolucion + "\n";
        s += "Penalizacion: " + penalizacion + "\n";
        s += "Local origen: " + localOrigen + "\n";
        s += "Local destino: " + localDestino + "\n";
        s += "Moto: " + moto + "\n";
        s += "Pagament: " + pagament + "\n";
        return s;
    }

    /**
     * Devuelve un boolean indicado si el cliente tuvo  penalizacion de la reserva.
     * 
     * @return boolean
     */
    public boolean haTenidoPenalizacion() {
       return pagament.getPenalizacion() > 0; 
    }
    
    /**
     * Devuelve el coste total de la reserva.
     * 
     * @return double
     */
    public double getCosteTotal() {
        return pagament.getTotal();
    }
}
