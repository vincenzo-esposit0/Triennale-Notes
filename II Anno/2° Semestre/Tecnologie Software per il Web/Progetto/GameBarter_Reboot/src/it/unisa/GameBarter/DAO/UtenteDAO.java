package it.unisa.GameBarter.DAO;

import java.util.List;

import it.unisa.GameBarter.Model.*;

public interface UtenteDAO {
	
	/** Recupera tutti gli utenti dal DB. */
	public List<Utente> getAllUtenti();
	
	/** Recupera un oggetto Utente esistente a partire dall'id. */
	public Utente getUtente(int id);
	
	/** Crea un oggetto Utente e restituisce l'id. */
	public int createUtente(Utente utente);
	
	/** Aggiorna un oggetto Utente esistente. */
	public boolean updateUtente(Utente utente);
	
	/** Cancella un oggetto Utente esistente. */
	public boolean deleteUtente(Utente utente);

}
