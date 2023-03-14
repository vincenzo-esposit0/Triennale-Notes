package it.unisa.Agenzia;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import it.unisa.Exception.IllegalClienteException;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
import it.unisa.parco.Gestore.Parco;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class Agenzia {
	/**
	 * Questo costruttore crea una nuova agenzia con piva, nome, indirizo, tel, incasso
	 * 
	 * @param piva dell'agenzia
	 * @param nome dell'agenzia
	 * @param indirizzo dell'agenzia
	 * @param tel dell'agenzia
	 * @param incasso dell'agenzia
	 */
	public Agenzia(String piva, String nome, String indirizzo, String tel, double incasso){
		
		this.piva=piva;
		this.nome=nome;
		this.incasso=incasso;
		this.tel=tel;
		this.indirizzo=indirizzo;
		pacchetti=new ArrayList<Pacchetto>();
		pacchettivenduti=new ArrayList<Pacchetto>();
		pacchettiprenotati = new ArrayList<Pacchetto>();
		
				
	}
	
	/** 
	 * Questo metodo crea un nuovo pacchetto
	 * 
	 * @param codice del pacchetto
	 * @param nome del pacchetto
	 * @param descrizione del pacchetto
	 * @param prezzo del pacchetto
	 * @param numbiglietti del pacchetto
	 * @param parco del pacchetto
	 * @see Parco
	 */
	public void creaPacchetto(String codice, String nome, String descrizione, double prezzo, int numbiglietti, Parco parco){
		
		pacchetti.add(new Pacchetto(codice, nome, descrizione, prezzo, numbiglietti,parco));
		
	}

	/**
	 * Aggiunge un pacchetto ai pacchetti venduti 
	 * 
	 * @param pacchetto da aggiungere ai pacchetti venduti
	 * @see Pacchetto
	 */
	public void addPacchettoVenduto(Pacchetto pacchetto){
		
		pacchettivenduti.add(pacchetto);
	}
	
	/**
	 * Aggiunge un pacchetto ai pacchetti prenotati
	 * 
	 * @param p da aggiungere ai pacchetti prenotati
	 * @see Pacchetto
	 */
	public void addPacchettoPrenotato(Pacchetto p){
		
		pacchettiprenotati.add(p);
	}
	
	/**
	 * Aggiunge un pacchetto ai pacchetti 
	 * 
	 * @param p da aggiungere ai pacchetti 
	 * @see Pacchetto
	 */
	public void addPacchetto(Pacchetto p){
		
		pacchetti.add(p);
	}
	
	/**
	 * Questo metodo vende un pacchetto.
	 * 
	 * @param pacchetto pacchetto che deve essere venduto
	 * @param cliente cliente che acquista il pacchetto
	 * @param datacquisto data in cui è avvenuto l'acquisto
	 * @exception IllegalClienteException eccezione  che viene lanciata nel momento in cui il pacchetto era stato già prenotato da un cliente
	 * e il cliente che acquista il pacchetto non è compatibile col cliente che ha prenotato il pacchetto
	 */
	public void vendiPacchetto(Pacchetto pacchetto, Cliente cliente, GregorianCalendar datacquisto){
		
		
		if(pacchetto.getCliente()!=null){
			
			
			if(!pacchetto.getCliente().getCf().equals(cliente.getCf())){
				
				throw new IllegalClienteException("Cliente non concorde con cliente che ha prenotato il pacchetto!");
			}
			
			this.pacchettiprenotati.remove(pacchetto);
			
		}
		
		else{
			
			this.pacchetti.remove(pacchetto);
		}
		
		pacchetto.setCliente(cliente);
		pacchetto.setDataAcquisto(datacquisto);
		this.pacchettivenduti.add(pacchetto);
		incasso=incasso+pacchetto.getPrezzo();
		
	}
	
	
	/**
	 * Questo metodo prenota un pacchetto. Aggiunge il pacchetto all' arrraylist dei pacchetti prenotati per poi settare cliente e data di prenotazione del pacchetto
	 * 
	 * 
	 * @param cliente cliente che prenota il pacchetto
	 * @param pacchetto pacchetto che deve essere prenotato
	 * @param dataprenotazione data in cui avviene la prenotazione del pacchetto
	 */
	public void prenotaPacchetto(Cliente cliente, Pacchetto pacchetto, GregorianCalendar dataprenotazione){
		
			pacchetto.setDataPrenotazione(dataprenotazione);
			pacchetto.setCliente(cliente);
			this.pacchettiprenotati.add(pacchetto);
			this.pacchetti.remove(pacchetto);
		
	}

	/**
	 * Questo metodo permette di ottenere i pacchetti venduti 
	 * 
	 * @return ArrayList tutti i pacchetti venduti
	 */
	public ArrayList<Pacchetto> getPacchettiVenduti(){
		
		return pacchettivenduti;
	}
	
	/**
	 * Questo metodo ritorna la lista dei pacchetti prenotati
	 * 
	 * @return ArrayList tutti i pacchetti prenotati
	 */
	public ArrayList<Pacchetto> getPacchettiPrenotati(){
		
		return pacchettiprenotati;
	}
	
	/**
	 * Questo metodo permette di ottenere i pacchetti disponibili in quell'agenzia
	 * 
	 * @return ArrayList tutti i pacchetti disponibili
	 */
	public ArrayList<Pacchetto> getPacchetti(){
		
		return pacchetti;
	}
	
	/**
	 * Questo metodo ritorna il tel di quell'agenzia
	 * 
	 * @return tel dell'agenzia
	 */
	public String getTel(){
		
		return tel;
	}
	
	/**
	 * Questo metodo ritorna il nome di quell'agenzia 
	 * 
	 * @return nome dell'agenzia
	 */
	public String getNome(){
		
		return nome;
	}
	
	/**
	 * Questo metodo ritorna l'incasso dell'agenzia
	 * 
	 * @return incasso dell'agenzia
	 */
	public double getIncasso(){
		
		return incasso;
	}
	
	/**
	 * Questo metodo ritorna la piva dell'agenzia
	 * 
	 * @return piva dell'agenzia
	 */
	public String getPIva(){
		
		return piva;
	}
	
	/**
	 * Questo metodo ritorna l'indirizzo dell'agenzia
	 * 	
	 * @return indirizzo dell'agenzia
	 */
	public String getIndirizzo(){
		
		return indirizzo;
	}
	
	public String toString(){
		
		return getClass().getName() +"[Nome" + nome + "Piva" + piva + "Indirizzo" + indirizzo + "Tel" + tel + "Pacchetti" + pacchetti + "Pacchetti prenotati" + pacchettiprenotati + "Pacchetti venduti" + 
		pacchettivenduti + "Incasso" + incasso+"]";
	}
	
	private String piva;
	private ArrayList<Pacchetto> pacchettivenduti;
	private double incasso;
	private String indirizzo;
	private String tel;
	private ArrayList<Pacchetto> pacchetti;
	private ArrayList<Pacchetto> pacchettiprenotati;
	private String nome;
}

