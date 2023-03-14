package it.unisa.parco.Gestore;
import java.util.ArrayList;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class ParcoAvventura extends Parco {
	/**
	 * Costruisce un parco avventura basandosi su nome, sede e relativo percorso che si può percorrere nel parco
	 * 
	 * @param codice codice del parco
	 * @param nome nome del parco
	 * @param sede sede del paroc
	 * @param numbigliettivendita biglietti disponibili 
	 * @param percorso percorso del relativo al parco
	 */
	
	public ParcoAvventura(String codice, String nome, String sede, int numbigliettivendita, String percorso){
		
		super(codice, nome, sede, numbigliettivendita);
		this.percorso=percorso;
		
	}

	
	/**
	 * Questo metodo restituisce il percorso
	 * 
	 * @return percorso del parco
	 */
	
	public String getPercorso()
	{
		return percorso;
	}
	 /**
	  * Questo metodo setta il percorso
	  * 
	  * @param percorso percorso del parco
	  */
	
	public void setPercorso(String percorso)
	{
		this.percorso=percorso;
	}
	
	public String toString(){
		
		return super.toString() + "[Percorso" + percorso+"]";
	}
	
	
	public boolean equals(Object object){
		
		if(!super.equals(object)){
			
			return false;
		}
		
		ParcoAvventura other=(ParcoAvventura) object;
		return percorso.equals(other.getPercorso());
	}
	
	private String percorso;
}