package it.unisa.GameBarter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unisa.GameBarter.Model.*;

public class MySQLUtenteDAO implements UtenteDAO {
	
	/** La query per l'inserimento di un nuovo cliente */
    private static final String CREATE_QUERY = "INSERT INTO utente (nome, cognome, username, password, email, valuta, indirizzo, admin) VALUES (?,?,?,?,?,?,?,?)";
    
    /** La query per la lettura di un singolo cliente. */
    private static final String READ_QUERY = "SELECT idutente,  nome, cognome, username, password, email, valuta, indirizzo, admin FROM utente WHERE idutente = ?";
    
    /** La query per la lettura di tutti i clienti. */
    private static final String READ_ALL_QUERY = "SELECT idutente,  nome, cognome, username, password, email, valuta, indirizzo, admin FROM utente";
    
    /** La query per l'aggiornamento di un singolo cliente. */
    private static final String UPDATE_QUERY = "UPDATE utente SET nome=?, cognome=?, username=?, password=?, email=?, valuta=?, indirizzo=?, admin=? WHERE idutente = ?";
    
    /** La query per la cancellazione di un singolo cliente. */
    private static final String DELETE_QUERY = "DELETE FROM utente WHERE idutente = ?";


	@Override
	public List<Utente> getAllUtenti() {
		List<Utente> utenti = new ArrayList<Utente>();
		Utente utente = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
        	con = MySQLDAO.createConnection();
        	statement = con.prepareStatement(READ_ALL_QUERY);
        	statement.execute();
        	result = statement.getResultSet();
        	
        	while(result.next()) {
        		utente = new Utente(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), 
        				result.getString(6), result.getInt(7), result.getString(8), result.getBoolean(9));
        		utenti.add(utente);
        	}
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
		
		return utenti;
	}

	@Override
	public Utente getUtente(int id) {
		Utente utente = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		 try {
	            con = MySQLDAO.createConnection();
	            statement = con.prepareStatement(READ_QUERY);
	            statement.setInt(1, id);
	            statement.execute();
	            result = statement.getResultSet();
	 
	            if (result.next() && result != null) {
	        		utente = new Utente(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), 
	        				result.getString(6), result.getInt(7), result.getString(8), result.getBoolean(9));
	            } 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                result.close();
	            } catch (Exception rse) {
	                rse.printStackTrace();
	            }
	            try {
	                statement.close();
	            } catch (Exception sse) {
	                sse.printStackTrace();
	            }
	            try {
	                con.close();
	            } catch (Exception cse) {
	                cse.printStackTrace();
	            }
	        }
	 
		
		return utente;
	}

	@Override
	public int createUtente(Utente utente) {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, utente.getNome());
            statement.setString(2, utente.getCognome());
            statement.setString(3, utente.getUsername());
            statement.setString(4, utente.getPassword());
            statement.setString(5, utente.getEmail());
            statement.setInt(6, utente.getValuta());
            statement.setString(7, utente.getIndirizzo());
            statement.setBoolean(8, utente.isAdmin());
            statement.execute();
            result = statement.getGeneratedKeys();
 
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
            	statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return -1;

	}

	@Override
	public boolean updateUtente(Utente utente) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
        	con = MySQLDAO.createConnection();
        	statement = con.prepareStatement(UPDATE_QUERY);
        	statement.setString(1, utente.getNome());
            statement.setString(2, utente.getCognome());
            statement.setString(3, utente.getUsername());
            statement.setString(4, utente.getPassword());
            statement.setString(5, utente.getEmail());
            statement.setInt(6, utente.getValuta());
            statement.setString(7, utente.getIndirizzo());
            statement.setBoolean(8, utente.isAdmin());
            
            statement.setInt(9, utente.getIdutente());
            
        	statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}

	@Override
	public boolean deleteUtente(Utente utente) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(DELETE_QUERY);
            statement.setInt(1, utente.getIdutente());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
            	con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}

}
