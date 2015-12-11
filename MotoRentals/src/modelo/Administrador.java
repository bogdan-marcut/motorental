/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Shigekuni
 */
public class Administrador extends Usuario{
    
    public Administrador(){
        
    }
    
    public Administrador(String id, String nombre, String usuario, String contrasenya){
        super.CC = id;
        super.nombre = nombre;
        super.usuario = usuario;
        super.contrasenya = contrasenya;
    }
    
}
