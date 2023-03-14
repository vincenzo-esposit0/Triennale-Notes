package it.unisa.parco.Gestore;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class Gestore {
	
	/**
	 * Questo metodo consente di accedere all'area gestore solo con username/password corretti 
	 * 
	 * @param username del gestore 
	 * @param password del gestore 
	 */
	public Gestore(String username, String password){
		
		this.username=username;
		this.password=password;
		
		parchi=new ArrayList<Parco>();
	}
	
	/**
	 * Questo metodo aggiunge un parco ai parchi gestiti
	 * 
	 * @param parco da aggiungere ai parchi gestiti
	 * @see Parco
	 */
	
	public void addParco(Parco parco) {
		
		this.parchi.add(parco);
	}
	
	/**
	 * Questo metodo restituisce l'username
	 * 
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * Questo metodo restituisce la password
	 * 
	 * @return password
	 */
	public String getPassword()
	{
		return password;
	}
	
	
	/**
	 * Questo metodo restituisce i parchi gestiti
	 * 
	 * @return parchi
	 * @see Parco
	 */
	public ArrayList<Parco> getParchi()
	{
		return parchi;
	}
	
	public String toString(){

		return getClass().getName() + "[Username" + username + "Password" + password + "Parco" + parchi+"]"; 
	}
	
	private String username;
	private String password;
	private ArrayList<Parco> parchi;

}
