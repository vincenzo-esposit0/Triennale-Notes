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
public class Biglietto {
	/**
	 * Questo costruttore crea un biglietto con codice, nome, prezzo, data acquisto, attvità appurabili con lo stesso e riferimento al cliente
	 * 
	 * @param codice del biglietto
	 * @param nome del biglietto
	 * @param prezzo del biglietto
	 * @param datacquisto del biglietto
	 * @param attivita svolgibili con quel biglietto
	 * @param cliente proprietario del biglietto
	 * @see Attivita 
	 * @see Cliente
	 */
	public Biglietto(String codice,String nome, double prezzo,GregorianCalendar datacquisto, ArrayList<Attivita> attivita, Cliente cliente){
		
		this.codice=codice;
		this.prezzo=prezzo;
		this.attivita=attivita;
		this.nome=nome;
		this.cliente=cliente;
		this.datacquisto=datacquisto;
		
		
	}
	
	/**
	 * Questo metodo costruttore crea un biglietto con codice, nome, prezzo, data di acquisto, e riferimento al cliente
	 * 
	 * @param codice del biglietto
	 * @param nome del biglietto
	 * @param prezzo del biglietto
	 * @param datacquisto del biglietto
	 * @param cliente proprietario del biglietto
	 */
	public Biglietto(String codice, String nome, double prezzo, GregorianCalendar datacquisto, Cliente cliente){
		
		this.codice=codice;
		this.prezzo=prezzo;
		this.nome=nome;
		this.cliente=cliente;
		this.attivita= null;
		this.datacquisto=datacquisto;
		
		
	}
	
	/**
	 * Questo metodo setta il prezzo del biglietto
	 * 
	 * @param prezzo del biglietto
	 */
	public void setPrezzo(double prezzo){
		
		this.prezzo=prezzo;
	}
	
	/**
	 * Questo metodo setta la data di acquisto del biglietto
	 * 
	 * @param d data di acquisto
	 */
	public void setDatAcquisto(GregorianCalendar d){
		
		this.datacquisto=d;
	}
	
	/**
	 * Questo metodo aggiunge un attività alle attività del biglietto
	 * 
	 * @param attivita da aggiungere
	 * @see Attivita
	 */
	public void addAttivita(Attivita attivita){
		
		this.attivita.add(attivita);
		
	}
	
	/**
	 * Questo metodo setta il nome al biglietto
	 * 
	 * @param nome del biglietto
	 */
	public void setNome(String nome){
		
		this.nome=nome;
		
	}
	
	/**
	 * Questo metodo setta l'acquirente del biglietto
	 * 
	 * @param c acquirente del biglietto
	 * @see Cliente
	 */
	public void setCliente(Cliente c){
		
		this.cliente= cliente;
		
	}
	
	/**
	 * Questo metodo ritorna il codice del biglietto
	 * 
	 * @return codice del biglietto
	 */
	public String getCodice(){
		
		return codice;
	}
	
	/**
	 * Questo metodo ritorna il prezzo del biglietto
	 * 
	 * @return prezzo del biglietto
	 */
	public double getPrezzo(){
		
		return prezzo;
		
	}
	
	/**
	 * Questo metodo ritorna le attività relative a quel biglietto
	 * 
	 * @return ArrayList tutte le attività relative al parco
	 */
	public ArrayList<Attivita> getAttivita(){
		
		return attivita;
	}
	
	/**
	 * Questo metodo ritorna il nome del biglietto
	 * 
	 * @return nome del biglietto
	 */ 
	public String getNome(){
		
		return nome;
	}

	/**
	 * Questo metodo ritorna il nome dell'acquirente del biglietto 
	 * @return acquirente del biglietto
	 * @see Cliente
	 */
	public Cliente getCliente(){
		
		return cliente;
	}
	
	/**
	 * Questo metodo ritorna la data di acquisto del biglietto
	 * 
	 * @return data di acquisto del biglietto
	 */
	public GregorianCalendar getDatAcquisto(){
		
		return datacquisto;
		
	}
	
	public String toString(){
		return getClass().getName() + "[Codice" + codice + "Prezzo" + prezzo + "Attività" + attivita + "Nome" + nome + "Cliente" + cliente+"]";
	}
	
	private String codice;
	private double prezzo;
	private ArrayList<Attivita> attivita;
	private String nome;
	private Cliente cliente;
	private GregorianCalendar datacquisto=null;

}
