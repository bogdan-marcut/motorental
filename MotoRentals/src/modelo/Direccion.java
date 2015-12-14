package modelo;

/**
 * Clase direccion.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Direccion {
    
    private String calle;
    private String numero;
    private String CP;
    private String poblacion;
    
    /**
     * Constructor vacio de la clase.
     */
    public Direccion() {

    }
    
    /**
     * Constructor con todos los atributos de la clase.
     * 
     * @param calle
     * @param numero
     * @param CP
     * @param poblacion 
     */
    public Direccion(String calle, String numero, String CP, String poblacion) {
        this.calle = calle;
        this.numero = numero;
        this.CP = CP;
        this.poblacion = poblacion;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the CP
     */
    public String getCP() {
        return CP;
    }

    /**
     * @param CP the CP to set
     */
    public void setCP(String CP) {
        this.CP = CP;
    }

    /**
     * @return the poblacion
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    
    public String toString() {
        String s = "";
        s += "Direccion: " + this.calle + " " + this.numero + ", " + this.CP + ", " + this.poblacion + "\n";
        return s;
    }
}
