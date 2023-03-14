package it.unisa.Agenzia;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */

public class Cliente {
	
	/**
	 * Costruisce un cliente basandosi su nome, cognome, sesso, età e codicefiscale
	 * 
	 * @param nome nome del cliente
	 * @param cognome cognome del cliente
	 * @param eta età del cliente
	 * @param cf codice fiscale del cliente
	 */
	public Cliente(String cf, String nome, String cognome,int eta){
		
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.cf= cf;
	}	

	/**
	 * Ritorna nome del cliente
	 * 
	 * @return nome del cliente
	 */
	public String getNome(){
		
		return nome;
	}
	
	/**
	 * Ritorna cognome del cliente
	 * 
	 * @return cognme del cliente
	 */
	public String getCognome(){
		
		return cognome;
	}
	
	/**
	 * Ritorna età del cliente
	 * 
	 * @return età del cliente
	 */
	
	public int getEta(){
		
		return eta;
	}

	/**
	 * Ritorna codice fiscale cliente
	 * 
	 * @return codice fiscale cliente
	 */
	public String getCf(){
		
		return cf;
	}
	
	
	/**
	 * Ritorna lo stato dell'oggetto
	 */
	public String toString() {
		return getClass().getName() + " [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", cf=" + cf + "]";
	}



	private String nome;
	private String cognome;
	private int eta;
	private String cf;
}
