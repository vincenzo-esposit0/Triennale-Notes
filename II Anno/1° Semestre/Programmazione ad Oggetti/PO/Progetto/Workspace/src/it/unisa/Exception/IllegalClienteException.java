package it.unisa.Exception;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class IllegalClienteException extends RuntimeException {
	
	/**
	 * Costruisce un messaggio d'errore dell'eccezione "IllegalClienteException"
	 * 
	 * @param message in caso di eccezione
	 */
	public IllegalClienteException(String message){
		
		super(message);
	}
	
	public IllegalClienteException(){
		
		
	}
	
	
}
