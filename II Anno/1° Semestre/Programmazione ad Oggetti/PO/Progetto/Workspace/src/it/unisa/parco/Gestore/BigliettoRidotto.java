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
public class BigliettoRidotto extends Biglietto{
	
	/**
	 * Questo metodo costruttore crea un bigliettoridotto con codice, nome, prezzo, data di acquisto, lista delle attività, cliente acquirente e sconto applicato
	 * 
	 * @param codice del biglietto 
	 * @param nome del biglietto
	 * @param prezzo del biglietto 
	 * @param datacquisto del biglietto
	 * @param attivita appurabili con questo biglietto
	 * @param cliente acquirente del biglietto
	 * @param sconto applicato a quel biglietto
	 * @see Attivita
	 * @see Cliente
	 */
	public BigliettoRidotto(String codice,String nome, double prezzo, GregorianCalendar datacquisto,  ArrayList<Attivita> attivita, Cliente cliente, double sconto){
		
		super(codice,nome, prezzo, datacquisto, attivita,cliente);
		
		this.sconto=sconto;
		
	}
	
	/**
	 * Questo metodo ritorna lo sconto del biglietto
	 * 
	 * @return sconto del biglietto (intero)
	 */
	public double getSconto(){
		
		return sconto;
	}
	
	/**
	 * Questo metodo applica lo sconto al biglietto
	 */
	public void applicaSconto(){
		
		double prezzosconto=(sconto/100)*this.getPrezzo();
		double prezzo= this.getPrezzo()-prezzosconto;
		this.setPrezzo(prezzo);
		
	}
	
	public String toString(){
	
		return super.toString() + "[Sconto" + sconto+"]";
	}
	
	private double sconto;

}
