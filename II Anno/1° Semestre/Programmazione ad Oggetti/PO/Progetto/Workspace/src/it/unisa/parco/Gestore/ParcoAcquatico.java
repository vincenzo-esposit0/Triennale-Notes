package it.unisa.parco.Gestore;
import java.util.ArrayList;

/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class ParcoAcquatico extends Parco
{
	/**
	 * Costruisce un parco avventura basandosi su nome, sede e relativo percorso che si può percorrere nel parco
	 * 
	 * @param codice del parco
	 * @param nome del parco
	 * @param sede del parco
	 * @param numbigliettivendita biglietti disponibili del parcos
	 * @param numpiscine numero di piscine
	 */
	
	public ParcoAcquatico(String codice, String nome, String sede, int numbigliettivendita, int numpiscine){
		
		super(codice, nome, sede, numbigliettivendita);
		this.numpiscine=numpiscine;
		
	}
	
	
	/**
	 * Questo metodo restituisce il numero delle piscine
	 * 
	 * @return numero delle piscine nel parco
	 */
	public int getNumPiscine()
	{
		return numpiscine;
	}
	
	/**
	 * Questo metodo setta il numero delle piscine del parco
	 * 
	 * @param numpiscine numero piscine
	 */
	public void setNumPiscine(int numpiscine)
	{
		this.numpiscine=numpiscine;
	}
	
	public String toString(){
		
		return super.toString() + "[numero piscine" + numpiscine+"]";
	}
	
	public boolean equals(Object object){
		
		if(!super.equals(object)){
			
			return false;
		}
		
		ParcoAcquatico other=(ParcoAcquatico) object;
		return numpiscine==other.getNumPiscine();
	}
	private int numpiscine;
		
}
