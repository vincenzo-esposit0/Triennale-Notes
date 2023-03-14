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
	 * Costruisce una nuova attivit� basandosi su nome, costo, ora inizio e ora fine
	 * 
	 * @param nome nome dell'attivit�
	 * @param costo dell'attivit�
 	 * @param orainizio dell'attivit�
 	 * @param orafine dell'attivit�
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
	 * Setta il nome dell'attivit�
	 * 	
	 * @param nome dell'attivit� da impostare
	 */
	public void setNome(String nome){
		
		this.nome=nome;
	}
	
	/**
	 * Ritorna il nome dell'attivit� 
	 * 	
	 * @return il nome dell'attivit�
	 */

	public String getNome(){
		
		return nome;
	}

	/**
	 * Ritorna l'array contentente le promozioni di quella data attivit�
	 * 
	 * @return promozioni relative all'attivit�
	 * @see Promozione
	 */
	
	public ArrayList<Promozione> getPromozioni(){
		
		return promozioni;
	}

	/**
	 * Ritorna l'ora di inizio di quell'attivit�
	 * 
	 * @return ora di inizio dell'attivit�
	 */
	public Time getOraInizio(){
		
		return orainizio;
	}

	/**
	 * Ritorna l'ora di fine di quell'attivit�
	 * 
	 * @return ora di fine dell'attivit�
	 */
	public Time getOraFine(){
		
		return orafine;
	}

	/**
	 * Ritorna il costo di quell'attivit�
	 * 
	 * @return il costo dell'attivit�
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
