/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mat.aules
 */
public class Local {
    private int ID;
    private int capacidad;
    private int motosDisponibles;
    private ArrayList<Moto> motos;
    private Direccion direccion;
    private ArrayList<Reserva> reservas;

    public Local() {

    }
    
    public Local(int ID, int capacidad, int motosDisponibles, ArrayList<Moto> motos, Direccion direccion, ArrayList<Reserva> reservas) {
        this.ID = ID;
        this.capacidad = capacidad;
        this.motosDisponibles = motosDisponibles;
        this.motos = motos;
        this.direccion = direccion;
        this.reservas = reservas;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
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


}
