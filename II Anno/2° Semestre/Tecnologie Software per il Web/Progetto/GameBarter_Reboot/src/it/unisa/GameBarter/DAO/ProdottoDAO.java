package it.unisa.GameBarter.DAO;

import java.util.List;

import it.unisa.GameBarter.Model.Prodotto;

public interface ProdottoDAO {
	
	/** Recupera tutti i prodotti dal DB. */
	public List<Prodotto> getAllProdotto();
	
	/** Recupera un oggetto Prodotto esistente a partire dall'id. */
	public int getProdotto(int id_utente, int id_prodotto);
	
	/** Crea un oggetto Prodotto e restituisce l'id. */
	public int createProdotto(Prodotto prodotto);
	
	/** Aggiorna un oggetto Prodotto esistente. */
	public boolean updateProdotto(int id_prodotto, String titolo, int prezzo, String piattaforma, String genere, String anno);
	
	/** Cancella un oggetto Prodotto esistente. */
	public boolean deleteProdotto(String titolo);
	
	public Prodotto searchTitle(String titolo);

	/** Recupera tutti i prodotti dal DB in base al paramentro genere. */
	public List<Prodotto> getProdottiSpecifici(String genere);
	
	public int addGameUser(int utente, int quantità, int prodotto) ;
	
	public List<Prodotto> gameUserList(int id_utente);
	
	public int updateGameUser(int utente, int quantità, int prodotto);
	
	public int removeGameUser(int utente, int prodotto);
	
	public int removeGameOne(int utente, int prodotto);
	
	public int ceckVolume(int utente, int prodotto);
}
