package it.unisa.parco.Gestore;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class Promozione {
	
	/**
	 * Questo metodo costruttore crea una nuova promozione con codice, nome, descrizione, sconto, data inizio, data scadenza
	 * 
	 * @param codice della promozione
	 * @param nome della promozione
	 * @param descrizione della promozione
	 * @param sconto della promozione 
	 * @param datainizio della promozione 
	 * @param datascadenza della promozione 
	 */
	public Promozione(String codice, String nome,  String descrizione,int sconto, GregorianCalendar datainizio, GregorianCalendar datascadenza){
		
		this.codice=codice;
		this.nome=nome;
		this.datainizio=datainizio;
		this.datascadenza=datascadenza;
		this.sconto=sconto;
		this.attivita=new ArrayList<Attivita>();
		this.descrizione=descrizione;
		
	}
	
	/**
	 * Aggiunge un attività alla lista delle attività in promozione 
	 * 
	 * @param attivita da aggiungere 
	 * @see Attivita
	 */
	public void addAttivita(Attivita attivita){
		
		this.attivita.add(attivita);
	}
	
	/**
	 * Setta la data di inizio della promozione
	 * 
	 * @param data di inizio della promozione 
	 */
	public void setDataInizio(GregorianCalendar data){
		
		this.datainizio=data;
	}
	
	/**
	 * Setta la data di fine della promozione
	 * 
	 * @param data di fine della promozione 
	 */
	
	public void setDataScadenza(GregorianCalendar data){
		
		this.datascadenza=data;
	}
	
	/**
	 * Permette di settare lo sconto 
	 * 
	 * @param sconto (intero)
	 */
	public void setSconto(int sconto){
		
		this.sconto=sconto;
	}
	
	/**
	 * Ritorna il codice della promozione
	 * 
	 * @return codice della promozione 
	 */
	public String getCodice(){
		
		return codice;
	}
	
	/**
	 * Ritorna lo sconto applicato
	 * 
	 * @return sconto (intero)
	 */
	public int getSconto(){
		
		return sconto;
	}
	
	/**
	 * Ritorna il nome della promozione
	 * 
	 * @return nome della promozione
	 */
	public String getNome(){
		
		return nome;
	}
	
	/**
	 * Ritorna la data di inzio della promozione 
	 * 
	 * @return data di inizio della promozione
	 */
	public GregorianCalendar getDataInizio(){
		
		return datainizio;
	}
	
	/**
	 * Ritorna la data di fine della promozione 
	 * 
	 * @return data di fine della promozione
	 */
	public GregorianCalendar getDataScadenza(){
		
		return datascadenza;
	}
	
	/**
	 * Ritorna la lista delle attività in promozione
	 * 
	 * @return ArrayList lista delle promozioni per questa attività
	 * @see Attivita
	 */
	public ArrayList<Attivita> getAttivitaInPromo(){
		
		return attivita;
	}
	
	/**
	 * Ritorna la descrizione della promozione 
	 * 
	 * @return la descrizione della promozione
	 */
	public String getDescrizione(){
		
		return descrizione;
	}
	
	public String toString(){
		
		return getClass().getName() +"[Codice" + codice + "Nome" + nome + "Descrizione" + descrizione + "Data inizio" + datainizio + "Data scadenze " + datascadenza + "Sconto" + sconto + "Attivita" + attivita+"]";
	}
	
	private String codice;
	private String nome;
	private String descrizione;
	private GregorianCalendar datainizio;
	private GregorianCalendar datascadenza;
	private int sconto;
	private ArrayList<Attivita> attivita;

}
