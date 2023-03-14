package it.unisa.GameBarter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import it.unisa.GameBarter.Model.CartProdotto;
import it.unisa.GameBarter.Model.Ordine;
import it.unisa.GameBarter.Model.Utente;

public class MYSQLOrdine implements OrdineDAO {
	
	private static String CREATE_ORDER = "INSERT INTO ordine (data, utente, prezzo_totale) VALUES (?, ?, ?);";
	private static String UPDATE_USER = "UPDATE utente SET valuta = valuta - ? WHERE idutente = ?;";
	private static String ADD_PRODUCT = "INSERT INTO composizione (prodotto, quantità, ordine ) VALUES (?, ? , ?)";
	private static String SELECT_USER = "SELECT utente, prezzo, idaggiunto FROM aggiunto inner join prodotto on prodotto = idprodotto WHERE prodotto = ? LIMIT 1;";
	private static String REMOVE_BUY = "UPDATE aggiunto SET quantità = quantità - 1 WHERE prodotto = ? LIMIT 1;";
	private static String REMOVE_0 = "DELETE FROM aggiunto WHERE quantità = 0 AND idaggiunto = ?";
	private static String UPDATE_BR = "UPDATE utente SET valuta = valuta + ? WHERE idutente = ?";
	
	
	private static String PRODUCT_BUY = "SELECT idordine, titolo, quantità, prezzo, data FROM ordine inner join (composizione inner join prodotto on prodotto = idprodotto) on idordine = ordine WHERE utente = ?";

	private static String VIEW_ORDER = "SELECT idordine, data, titolo, composizione.quantità, username, prezzo_totale FROM utente inner join (ordine inner join (composizione inner join prodotto on prodotto = idprodotto)  on idordine = ordine ) on idutente = utente WHERE username = ? AND ? < data AND ? > data";
	
	
	
	public int creazioneOrdine(int utente, int prezzo_totale, List<CartProdotto> prodotti) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
			int id_ordine = 0;
			int id_utente = 0;
			int id_aggiunto = 0;
			int prezzo = 0;
			
			//Creazione ordine
			String data = LocalDateTime.now().toInstant(ZoneOffset.UTC).toString();
			
	
			statement.setString(1, data.substring(0, 10));
			statement.setInt(2, utente);
			statement.setInt(3, prezzo_totale);

		
            statement.execute();
            
            result = statement.getGeneratedKeys();
 
            if (result.next() && result != null) {
                id_ordine = result.getInt(1);
            }
            
            statement.close();
            result.close();
            
            //Aggiornamento saldo utente
            statement = con.prepareStatement(UPDATE_USER);
            statement.setInt(1, prezzo_totale);
            statement.setInt(2, utente );
            
            statement.execute();
            
            statement.close();
            
            //Aggiunta dei prodotti
            for(CartProdotto e : prodotti) {
            	statement = con.prepareStatement(ADD_PRODUCT);
                statement.setInt(1, e.getIdprodotto());
                statement.setInt(2, e.getVolume());
                statement.setInt(3, id_ordine);
                
                statement.execute();
                statement.close();
            }
            
            
            //Rimuovi prodotti
            for(CartProdotto e : prodotti) {
            	int i = e.getVolume();

            	
            	while(i > 0) {
            		statement = con.prepareStatement(SELECT_USER);
                	statement.setInt(1, e.getIdprodotto());
                	
                	statement.execute();
                           	
                	result = statement.getResultSet();
                	
                	while(result.next()) {
                		id_utente = result.getInt(1);
                		prezzo = result.getInt(2);
                		id_aggiunto = result.getInt(3);
                		
                	}
                    
                    statement.execute();
                    statement.close();
                    result.close();
                    
                    statement = con.prepareStatement(REMOVE_BUY);
                    statement.setInt(1, e.getIdprodotto());
                    statement.execute();
                    statement.close();

                    statement = con.prepareStatement(REMOVE_0);
                    statement.setInt(1, id_aggiunto);
                    statement.execute();
                    statement.close();
                    
                	statement = con.prepareStatement(UPDATE_BR);
                	statement.setInt(1, prezzo);
                	statement.setInt(2, id_utente);
                	
                	statement.execute();

                	statement.close();
              
                    
                    i--;
                    
            	}
            }
            
            //Aggiornamento saldo venditore

            return 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return -1;
		
	}


	@Override
	public List<Ordine> acquisti(Utente user) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Ordine> ordini = new ArrayList<Ordine>();
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(PRODUCT_BUY);
			statement.setInt(1, user.getIdutente());
			
			statement.execute();
			
			result = statement.getResultSet();
			
			while(result.next()) {
				ordini.add(new Ordine(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5)));
			}
			
			return ordini;
			

		} catch (SQLException e) {
            e.printStackTrace();
        } 
		
		
		return null;
	}


	
	@Override
	public List<Ordine> orderAdmin(String username, String startdate, String endDate) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Ordine> view = new ArrayList<Ordine>();
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(VIEW_ORDER);
			statement.setString(1, username);
			statement.setString(2, startdate);
			statement.setString(3, endDate);


			
			statement.execute();
			
			result = statement.getResultSet();
			
			while(result.next()) {
				view.add(new Ordine(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getInt(6)));
			}
			
			return view;
			

		} catch (SQLException e) {
            e.printStackTrace();
        } 
		
				return null;
	}

}
