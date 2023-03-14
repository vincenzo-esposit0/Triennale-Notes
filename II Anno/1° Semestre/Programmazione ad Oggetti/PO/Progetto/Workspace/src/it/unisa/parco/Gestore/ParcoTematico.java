package it.unisa.parco.Gestore;
import java.util.ArrayList;

/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class ParcoTematico extends Parco {
	
	/**
	 * Costruisce un parco tematico basandosi su nome, sede e relativo tema del parco
	 * 
	 * @param codice codice del parco
	 * @param nome nome del parco
	 * @param sede sede del parco
	 * @param numbigliettivendita biglietti disponibili
	 * @param tema tema del parco
	 */
	
	public ParcoTematico(String codice, String nome, String sede, int numbigliettivendita, String tema){
		
		super(codice, nome, sede, numbigliettivendita);
		this.tema=tema;
		
	}
	
	
	/**
	 * Questo metodo restituisce il tema
	 * 
	 * @return tema
	 */
	public String getTema()
	{
		return tema;
	}
	
	/**
	 * Questo metodo setta il tema
	 * 
	 * @param tema tema del parco
	 */
	public void setTema(String tema)
	{
		this.tema=tema;
	}
	
	public String toString(){
		
		return super.toString() + "[Tema" + tema+"]";
	}
	
	
	public boolean equals(Object object){
		
		if(!super.equals(object)){
			
			return false;
		}
		
		ParcoTematico other=(ParcoTematico) object;
		return tema.equals(other.getTema());
	}
	
	
	private String tema;
}
