package it.unisa.Agenzia;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import it.unisa.parco.Gestore.Parco;

/**
 * 
 * @author Paolo
 * @author Vincenzo Loris Proto
 */
public class Pacchetto {
	
	/**
	 * Questo costruttore crea un nuovo pacchetto con codice, nome, descrizione, prezzo, num biglietti e riferimento al parco 
	 * 
	 * @param codice del pacchetto 
	 * @param nome del pacchetto 
	 * @param descrizione del pacchetto 
	 * @param prezzo del pacchetto 
	 * @param numbiglietti del pacchetto 
	 * @param parco riferito al pacchetto 
	 * @see Parco
	 */
	public Pacchetto(String codice, String nome, String descrizione, double prezzo, int numbiglietti,Parco parco){
		
		this.codice= codice;
		this.nome=nome;
		this.descrizione=descrizione;
		this.prezzo=prezzo;
		this.numbiglietti= numbiglietti;
		this.parco=parco;
	}
	
	/**
	 * Questo metodo setta il nome del pacchetto 
	 * 
	 * @param nome nome da assegnare al pacchetto
	 */
	
	public void setNome(String nome){
		
		this.nome=nome;
	}
	
	/**
	 * Questo metodo setta il prezzo del pacchetto 
	 * 
	 * @param prezzo del pacchetto
	 */
	public void setPrezzo(double prezzo){
		
		this.prezzo=prezzo;
	}
	
	/**
	 * Questo metodo setta il cliente che acquista il pacchetto 
	 * 
	 * @param cliente che acquista il pacchetto
	 * @see Cliente 
	 */
	public void setCliente(Cliente cliente){
		
		this.cliente= cliente;
	}
	
	/**
	 * Questo metodo setta la descrizione al pacchetto 
	 * 
	 * @param descrizione del pacchetto 
	 */
	public void setDescrizione(String descrizione){
		
		this.descrizione=descrizione;
		
		
	}
	
	/**
	 * Questo metodo setta la data di prenotazione del pacchetto 
	 * 
	 * @param data di prenotazione 
	 */
	public void setDataPrenotazione(GregorianCalendar data){
		
		this.dataprenotazione=data;
	}
	
	/**
	 * Questo metodo setta la data di acquisto del pacchetto 
	 * 
	 * @param data di acquisto
	 */
	public void setDataAcquisto(GregorianCalendar data){
		
		this.datacquisto=data;
	}
	
	/**
	 * Questo metodo restituisce il nome del pacchetto
	 * 
	 * @return nome del pacchetto
	 */
	public String getNome(){
		
		return nome;
	}

	/** 
	 * Questo metodo restituisce la descrzione del pacchetto
	 * 
	 * @return descrizione del pacchetto 
	 */
	public String getDescrizione(){
		
		return descrizione;
	}
	
	/**
	 * Questo metodo restituisce il prezzo del pacchetto 
	 * 
	 * @return prezzo del pacchetto 
	 */
	public double getPrezzo(){
		
		return prezzo;
	}
	
	/**
	 * Questo metodo restituisce il parco associato al pacchetto
	 * 
	 * @return parco associato al pacchetto
	 * @see Parco
	 */
	public Parco getParco(){
		
		return parco;
	}
	
	/**
	 * Questo metodo restituisce la data di acquisto del pacchetto
	 * 
	 * @return data di acquisto del pacchetto
	 */
	public GregorianCalendar getDataAcquisto(){
		
		return datacquisto;
	}
	
	/**
	 * Questo metodo restituisce la data di prenotazione del pacchetto
	 * 
	 * @return data di prenotazione del pacchetto
	 */
	public GregorianCalendar getDataPrenotazione(){
		
		return dataprenotazione;
	}
	
	/**
	 * Questo metodo restituisce l'acquierente del pacchetto 
	 * 
	 * @return cliente acquirente del pacchetto
	 * @see Cliente 
	 */
	public Cliente getCliente(){
		
		return cliente;
	}
	
	/**
	 * Questo metodo restituisce il codice del pacchetto
	 * 
	 * @return codice del pacchetto
	 */
	public String getCodice(){
		
		return codice;
	}
	
	/**
	 * Questo metodo restituisce il numero di biglietti contenuti nel pacchetto
	 * 
	 * @return num biglietti nel pacchetto
	 */
	public int getNumBiglietti(){
		
		return numbiglietti;
	}
	
	public String toString(){
		
		return getClass().getName() +"Nome" + nome + "Descrizione" + descrizione + "Prezzo" + prezzo + "Numero biglietti" + numbiglietti + "Cliente" + cliente 
				+ "Codice" + codice + "Parco" + parco + "Data acquisto" + datacquisto + "Data prenotazione" + dataprenotazione+"]";
	}
	
	private String nome;
	private String descrizione;
	private double prezzo;
	private GregorianCalendar datacquisto=null;
	private GregorianCalendar dataprenotazione=null;
	private int numbiglietti;
	private Cliente cliente;
	private String codice;
	private Parco parco;

}
