package it.unisa.parco.Gestore;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class Attivita {
	
	/**
	 * Costruisce una nuova attività basandosi su nome, costo, ora inizio e ora fine
	 * 
	 * @param nome nome dell'attività
	 * @param costo dell'attività
 	 * @param orainizio dell'attività
 	 * @param orafine dell'attività
 	 */
	
	public Attivita(String nome, double costo, Time orainizio, Time orafine){
		
		this.nome=nome;
		this.orainizio=orainizio;
		this.orafine=orafine;
		this.costo=costo;
		promozioni=new ArrayList<Promozione>();
		
	}

	/**
	 * Aggiunge una promozione
	 * 
	 * @param promozione promozione da aggiungere alle promozioni
	 * @see Promozione
	 */
	public void addPromozione(Promozione promozione){
		
		promozioni.add(promozione);
		
	}

	/**
	 * Setta il nome dell'attività
	 * 	
	 * @param nome dell'attività da impostare
	 */
	public void setNome(String nome){
		
		this.nome=nome;
	}
	
	/**
	 * Ritorna il nome dell'attività 
	 * 	
	 * @return il nome dell'attività
	 */

	public String getNome(){
		
		return nome;
	}

	/**
	 * Ritorna l'array contentente le promozioni di quella data attività
	 * 
	 * @return promozioni relative all'attività
	 * @see Promozione
	 */
	
	public ArrayList<Promozione> getPromozioni(){
		
		return promozioni;
	}

	/**
	 * Ritorna l'ora di inizio di quell'attività
	 * 
	 * @return ora di inizio dell'attività
	 */
	public Time getOraInizio(){
		
		return orainizio;
	}

	/**
	 * Ritorna l'ora di fine di quell'attività
	 * 
	 * @return ora di fine dell'attività
	 */
	public Time getOraFine(){
		
		return orafine;
	}

	/**
	 * Ritorna il costo di quell'attività
	 * 
	 * @return il costo dell'attività
	*/
	public double getCosto(){
		
		return costo;
	}
	
	public String toString()
	{
		return getClass().getName() +"[Nome Attivita" + nome + "Promozioni" + promozioni + "Orario inizio" + orainizio.getTime() + "Orario fine" +orafine.getTime() + "Costo" + costo+"]";
	}

	private String nome;
	private ArrayList<Promozione> promozioni=null;
	private Time orainizio;
	private Time orafine;
	private double costo;
}
