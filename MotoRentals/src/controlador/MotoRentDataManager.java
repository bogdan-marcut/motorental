package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Gerente;
import modelo.Local;
import modelo.Moto;
import modelo.Pagament;
import modelo.Reserva;
import modelo.Usuario;

/**
 * Data manager per MotoRent
 * . Crea les estructures de dades necessàries
 * per a manegar l'aplicació de gestió d'MotoRent
 * .
 * @author Professors disseny de software
 */
public class MotoRentDataManager {

	/* -------------------------------------------------------------------
	 * Metodes a implementar per vosaltres. En aquests metodes creareu els
	 * vostres objectes a partir de la informacio obtinguda del fitxer XML
	 * 
	 * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
	 * dades que retorna el metode, es a dir que sou lliures de
	 * modificar-ho al gust, excepte les crides inicials que es fan.
	 * -------------------------------------------------------------------
	 */
	
        private ArrayList<Usuario> listaUsuarios;
        private ArrayList<Local> listaLocales;
        private ArrayList<Reserva> listaReservas;

        public MotoRentDataManager(){
            this.listaUsuarios = new ArrayList<>();
            this.listaLocales = new ArrayList<>();
            this.listaReservas = new ArrayList<>();
        }
    
	/**
	 * Obté les dades del fitxer XML passat per paràmetre
	 * 
	 * @param nomFitxer ruta del fitxer XML del que obtenir les dades
	 */
	public void obtenirDades(String nomFitxer) {
		MotoRentXMLParser parser = new MotoRentXMLParser(this);
		parser.parse(nomFitxer);
	}

	/**
	 * Crea a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de l'local. El podeu utilitzar o no
	 * @param capacitat quantita màxima de motos
	 * @param gestorID gestorID del local
	 * @param adreca adreça del local
	 */
	
	public void crearLocal(String id, String capacitat, String gestorID, String adreca) {
            Gerente g = new Gerente();
            String[] direc = adreca.split(",");
            String calle = direc[0].substring(0, direc[0].lastIndexOf(' '));
            String numero = direc[0].substring(direc[0].lastIndexOf(' ') + 1);
            Direccion direccion = new Direccion(calle,numero,direc[1],direc[2]);
            
            Iterator<Usuario> iterador = this.getListaUsuarios().iterator();
                while(iterador.hasNext()){
                    Usuario u = iterador.next();
                    if(u.getId().equals(gestorID) && u.isGerente()){
                        g = (Gerente) u;
                    }
                }

            this.listaLocales.add(new Local(id, Integer.parseInt(capacitat), g, new ArrayList<Moto>(), direccion, new ArrayList<Reserva>()));
	}

	/**
	 * Crea una nova moto a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la moto. El podeu utilitzar o no
         * @param matricula matrícula de la moto
         * @param marca marca de la moto
         * @param model model de la moto
	 * @param color color de la moto
	 * @param estat estat de la moto: "true" representa moto activa i "false" per reparar
	 */

	public Moto crearMoto(String id, String matricula, String marca, String model, String color, String estat) {

		/* TODO: Aqui feu el necessari per a crear les vostres motos
		 */

            return new Moto(id, matricula, marca, model, color, estat.charAt(0));
	}

	/**
	 * Crea un trajecte a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del trajecte. El podeu utilitzar o no
	 * @param client identificador del client. El podeu utilitzar o no
	 * @param moto identificador de la moto. El podeu utilitzar o no
	 * @param local_inici identificador del local d'inici
	 * @param hora_inici hora d'inici de trajecte
	 * @param local_fi identificador del local final de trajecte
	 * @param hora_fi hora de finalització de trajecte
	 */
	
	public void crearReserva(String id,String client,String moto, String cost, String falta, String local_inici,String hora_inici,String fecha_inici, String local_fi,String hora_fi,String fecha_fi) {
                
                String[] horaInicio = hora_inici.split(":");
                String[] fechaInicio = fecha_inici.split("/");
                String[] horaFin = hora_fi.split(":");
                String[] fechaFin = fecha_fi.split("/");
                Moto m = new Moto();
                Local localOrigen = new Local();
                Local localDestino = new Local();
                Cliente ci = new Cliente();
                Iterator<Moto> iteradorMoto;
                
                                
                Iterator<Local> iteradorLocal = this.listaLocales.iterator();
                while(iteradorLocal.hasNext()){
                    Local local = iteradorLocal.next();
                    iteradorMoto = local.getMotos().iterator();
                    
                    if(local.checkLocal(local_inici)){
                        localOrigen = local;
                    }
                    if(local.checkLocal(local_fi)){
                        localDestino = local;
                    }
                    
                    while(iteradorMoto.hasNext()){
                        Moto itMoto = iteradorMoto.next();
                        if(itMoto.getId().equals(moto)){
                            m = itMoto;
                        }
                    }
                }
                
                Date fechaRecogida = new Date(Integer.parseInt(fechaInicio[2]), Integer.parseInt(fechaInicio[1]), Integer.parseInt(fechaInicio[0]),
                        Integer.parseInt(horaInicio[2]), Integer.parseInt(horaInicio[1]), Integer.parseInt(horaInicio[0]));
                Date fechaDevolucion = new Date(Integer.parseInt(fechaFin[2]), Integer.parseInt(fechaFin[1]), Integer.parseInt(fechaFin[0]),
                        Integer.parseInt(horaFin[2]), Integer.parseInt(horaFin[1]), Integer.parseInt(horaFin[0]));
                
                for(Usuario us:this.listaUsuarios){
                    if(us.getId().equals(client)){
                        ci = (Cliente) us;
                    }
                }
                
                Reserva reserva = new Reserva(id, fechaRecogida, fechaDevolucion, 0, localOrigen, localDestino, m, new Pagament(0,0,0,0,Double.parseDouble(cost)),ci);
                
                localOrigen.getReservas().add(reserva);
                this.getListaReservas().add(reserva);
	}

	/**
	 * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del administrador
	 * @param nom nom del administrador
	 * @param usuari usuari del administrador
	 * @param password password del administrador
	 */
	public void crearAdmin(String id, String nom, String usuari, String password) {

            this.getListaUsuarios().add(new Administrador(id,nom,usuari,password));
	}
	
	/**
	 * Crea un nou gestor a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del gestor
	 * @param nom nom del gestor
	 * @param usuari usuari del gestor
	 * @param password password del gestor
	 */
	public void crearGestor(String id, String nom, String usuari, String password) {

		/* TODO: Creeu aqui el vostre admin
		 */
                String nombre = nom.substring(0, nom.indexOf(' '));
                String apellidos = nom.substring(nom.indexOf(' ')+1);
                
		this.getListaUsuarios().add(new Gerente(id, nombre, apellidos, usuari, password));
	}

	/**
	 * Crea un nou client a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del client
	 * @param nom nom del client
	 * @param dni dni del client
	 * @param adreca adreça del client
	 * @param usuari usuari al sistema del client
	 * @param password password del client
	 * @param vip true si el client es vip. false si no
	 * @param renovacio true si el client renova automaticament. false si no
	 * @param faltes nombre de faltes
	 */
	public void crearClient(String id, String nom, String dni, String adreca, String usuari, String password, String vip, String renovacio, String faltes) {

		/* TODO: Creeu aqui el vostre client
		 */
                String nombre = nom.substring(0, nom.indexOf(' '));
                String apellidos = nom.substring(nom.indexOf(' ')+1);
                String[] direc = adreca.split(",");
                String calle = direc[0].substring(0, direc[0].lastIndexOf(' '));
                String numero = direc[0].substring(direc[0].lastIndexOf(' ') + 1);
                Direccion direccion = new Direccion(calle,numero,direc[1],direc[2]);
                
                this.getListaUsuarios().add(new Cliente(id, nombre, apellidos, "", new Date(), usuari, password, Integer.parseInt(faltes), direccion));
	}

    /**
     * @return the listaUsuarios
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @return the listaLocales
     */
    public ArrayList<Local> getListaLocales() {
        return listaLocales;
    }

    /**
     * @param listaLocales the listaLocales to set
     */
    public void setListaLocales(ArrayList<Local> listaLocales) {
        this.listaLocales = listaLocales;
    }

    /**
     * @return the listaReservas
     */
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * @param listaReservas the listaReservas to set
     */
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
}
