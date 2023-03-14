package it.unisa.Exception;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class NoPromoException extends RuntimeException {

	/**
	 * Costruisce un messaggio d'errore dell'eccezione "RunTimeException"
	 * 
	 * @param message in caso di eccezione
	 */
	public NoPromoException(String message){
		
		super(message);
		
	}
	
	public NoPromoException(){}


	
	
}
