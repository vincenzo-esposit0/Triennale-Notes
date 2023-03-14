package it.unisa.parco.Gestore;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import it.unisa.Agenzia.Cliente;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class BigliettoPromo extends BigliettoRidotto{
	
	/**
	 * Questo metodo costruttore crea un bigliettopromo con codice, nome, prezzo, data di acquisto, lista delle attività, cliente acquirente e riferimento alla promozione
	 * 
	 * @param codice del biglietto
	 * @param nome del biglietto
	 * @param prezzo del biglietto 
	 * @param datacquisto del biglietto
	 * @param attivita appurabili con questo biglietto
	 * @param cliente proprietario del biglietto
	 * @param promozione riferita a questo biglietto
	 * @see Attivita
	 * @see Promozione
	 * @see Cliente
	 */
	public BigliettoPromo(String codice, String nome, double prezzo, GregorianCalendar datacquisto, ArrayList<Attivita> attivita, Cliente cliente, Promozione promozione){
		
		super(codice,nome, prezzo, datacquisto, attivita,cliente,promozione.getSconto());
		
		this.promo=promozione;
		
	}
	
	/**
	 * Questo metodo ritorna la promozione di quel biglietto
	 * 
	 * @return promozione di quel biglietto
	 */
	public Promozione getPromo(){
		
		return promo;
	}
	
	public String toString(){
		
		return super.toString() + "[Promozione" + promo+"]";
	}
	
	private Promozione promo=null;
}
