package modelo;

/**
 * Clase moto.
 *
 * @author Bogdan Marcut, Ivan Toro, Marc Valdivia
 */
public class Moto {
    
    private String id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private char estado;

    public Moto() {

    }
    
    /**
     * Constructor de la clase.
     * 
     * @param id
     * @param matricula
     * @param marca
     * @param modelo
     * @param color
     * @param estado 
     */
    public Moto(String id, String matricula, String marca, String modelo, String color, char estado) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the estado
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Devuleve un booleano que indica si el id enviado por parametro corresponde
     * con el id de la moto actual.
     * 
     * @param idMoto
     * @return boolean
     */
    public boolean checkMoto(String idMoto) {
        return idMoto.equals(this.getId());
    }
    
    /**
     * Devuelve un String con la informacion de la moto.
     * 
     * @return String
     */
    public String mostrarMoto() {
        return this.toString();
    }

    @Override
    public String toString() {
        String s = "";
        s += "ID moto: " + this.id + "\n";
        s += "Matricula: " + this.matricula + "\n";
        s += "Marca: " + this.marca + "\n";
        s += "Modelo: " + this.modelo + "\n";
        s += "Color: " + this.color + "\n";
        s += "Estado: " + this.estado + "\n";
        return s;
    }
}
