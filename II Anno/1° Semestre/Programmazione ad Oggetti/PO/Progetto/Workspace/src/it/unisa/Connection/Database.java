package it.unisa.Connection;
/**
 * 
* Gestisce l'apertura e la chiusura della connessione col Database
* Fornisce i metodi per l'esecuzione delle query sul Database
*/


import java.sql.*;
import java.util.Vector;

public class Database {
	
	public Database(String nomedb) { 
		
		this(nomedb, "", "");
		
	}
	
	public Database(String nomedb, String nomeuser, String pwduser) {
		
		this.nomedb = nomedb;
		this.nomeuser = nomeuser;
		this.pwduser = pwduser;
		connesso = false;
		errore = "";
		
	}
	/**
	 * Apre la connessione con il database.
	 * 
	 * @return boolean true se è andata a buon fine, altrimenti false se c'è stata una eccezzione
	 */
	public boolean connetti() {
		
		connesso = false;
		
		try {
			
			// Carico il driver JDBC per la connessione con il database MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			// Controllo che il nome del Database non sia nullo ("")
			if (!nomedb.equals("")) {
				
				db = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nomedb+"?verifyServerCertificate=false&useSSL=true", nomeuser, pwduser);
		
				// Connesso con successo
				connesso = true;
			} 
			else {
				
				System.out.println("Manca il nome del database!");
				System.exit(0);
			}
		} 
		
		catch (Exception exec) { 
			
			errore = exec.getMessage(); 
			System.out.println("SQLException: " + exec.getMessage());
		}
		
		return connesso;
	}
	

	
	/**
	 * Esegue una query di selezione dati sul database.
	 * 
	 * @param query una stringa che rappresenta un'istruzione SQL di tipo SELECT da eseguire
	 * @return Vector ritorna un Vector contenente tutte le tuple del risultato
	 */
	public Vector eseguiQuery(String query) {
		
		Vector ve = null;
		String[] record;
		int colonne = 0;
		
		try {
			
			
			Statement stmt = db.createStatement(); // Creo lo Statement per l'esecuzione della query
			ResultSet rs = stmt.executeQuery(query); // Ottengo il ResultSet dell'esecuzione della query
			
			ve = new Vector();
			ResultSetMetaData rsmd = rs.getMetaData();
			colonne = rsmd.getColumnCount();
			
			while(rs.next()) { // Creo il vettore risultato scorrendo tutto il ResultSet
				
				record = new String[colonne];
				
				for (int i=0; i<colonne; i++){ 
				
					record[i] = rs.getString(i+1);
				}
				
				ve.add( (String[]) record.clone() );
			}
			
			rs.close(); // Chiudo il ResultSet
			stmt.close(); // Chiudo lo Statement
			
		}
		
		
		catch (Exception e) {
			
			e.printStackTrace(); 
			errore = e.getMessage();
			
		}

		return ve;
	}
	
	/**
	 * Esegue una query di aggiornamento sul Database.
	 * 
	 * @param query una stringa che rappresenta un'istruzione SQL di tipo UPDATE da eseguire
	 * @return true ritrna true se l'esecuzione è andata a buon fine, altrimenti false se c'è stata un eccezione
	 */
	public boolean eseguiAggiornamento(String query) {
		
		int numero = 0;
		boolean risultato = false;
		
			try {
				
				Statement stmt = db.createStatement();
				numero = stmt.executeUpdate(query);
				risultato = true;
				stmt.close();
			} 
			
			catch (Exception e) {
				
				System.out.println("SQLException: " + e.getMessage());
				errore = e.getMessage();
				risultato = false;
				
			}
			
			return risultato;
	}
	
	/**
	 * Chiude la connessione con il Database
	*/
	public void disconnetti() {
		try {
			
			db.close();
			connesso = false;
		} 
		
		catch (Exception e) { 
			
			e.printStackTrace();
			
		}
	}
	
	public Boolean isConesso(){
		
		return connesso;
	}
	
	
	

	public String toString() {
		return getClass().getName() + "[nomedb=" + nomedb + ", nomeuser=" + nomeuser + ", pwduser=" + pwduser + ", errore=" + errore
				+ ", db=" + db + ", connesso=" + connesso + "]";
	}



	private String nomedb; // Nome del Database a cui connettersi
	private String nomeuser; // Nome utente utilizzato per la connessione al Database
	private String pwduser; // Password usata per la connessione al Database
	private String errore; // Raccoglie informazioni riguardo l'ultima eccezione sollevata
	private Connection db; // La connessione col Database
	private boolean connesso; // Flah che indica se la connessione è attiva o meno
}