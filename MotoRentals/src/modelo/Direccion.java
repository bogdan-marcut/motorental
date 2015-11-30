/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mat.aules
 */
public class Direccion {
    private String calle;
    private String numero;
    private String CP;
    private String poblacion;
    
    public Direccion() {

    }
    
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
}
