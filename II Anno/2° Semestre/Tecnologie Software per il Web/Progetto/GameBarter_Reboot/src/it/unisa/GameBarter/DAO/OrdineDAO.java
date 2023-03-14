package it.unisa.GameBarter.DAO;

import java.util.List;

import it.unisa.GameBarter.Model.CartProdotto;
import it.unisa.GameBarter.Model.Ordine;
import it.unisa.GameBarter.Model.Utente;

public interface OrdineDAO {
	public int creazioneOrdine(int utente, int prezzo_totale, List<CartProdotto> prodotti);
	
	public List<Ordine> acquisti(Utente user);
	
	public List<Ordine> orderAdmin(String username, String startdate, String endDate);
}
