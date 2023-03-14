package it.unisa.GameBarter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unisa.GameBarter.Model.Prodotto;


public class MySQLProdottoDAO implements ProdottoDAO {
	
	/** La query per l'inserimento di un nuovo prodotto */
    private static final String CREATE_QUERY = "INSERT INTO prodotto (titolo, prezzo, piattaforma, genere, anno) VALUES (?,?,?,?,?)";
    
    /** La query per la lettura di un singolo prodotto. */
    private static final String READ_QUERY = "SELECT * FROM aggiunto WHERE prodotto = ? AND utente = ?";
    
    /** La query per la lettura di un singolo prodotto. */
    private static final String READ_QUERY_TITLE = "SELECT * FROM prodotto WHERE titolo = ?";
    
    /** La query per la lettura di un singolo prodotto. */
    private static final String READ_QUERY_VOLUME = "SELECT quantità FROM aggiunto WHERE prodotto = ? AND utente = ?";
    
    /** La query per la lettura di tutti i prodotti. */
    private static final String READ_ALL_QUERY = "SELECT idprodotto, titolo, prezzo, sum(ifnull(quantità, 0)) as quantità, piattaforma, genere, anno FROM  prodotto left join aggiunto on Idprodotto = prodotto GROUP BY (idprodotto) HAVING quantità>0 ORDER BY (titolo) ";
    
    /** La query per la lettura di tutti i prodotti in base al parametro genere */
    private static final String READ_ALL_QUERY_SPECIFIED = "SELECT idprodotto, titolo, prezzo, sum(ifnull(quantità, 0)) as quantità, piattaforma, genere, anno FROM  aggiunto right join prodotto on prodotto=idprodotto WHERE genere = ? GROUP BY (idprodotto) ORDER BY (titolo)";
    
    /** La query per l'aggiornamento di un singolo prodotto. */
    private static final String UPDATE_QUERY = "UPDATE prodotto SET titolo=?, prezzo=?, piattaforma=?, genere=?, anno=? WHERE idprodotto = ?";
    
    /** La query per l'aggiornamento di un singolo prodotto. */
    private static final String INSERT_QUERY_USER = "INSERT INTO aggiunto (utente, quantità, prodotto) VALUES (?,?,?)";
    
    private static final String UPDATE_QUERY_USER = "UPDATE aggiunto SET quantità = quantità + ? WHERE utente = ? AND prodotto = ?";
    
    /** La query per la cancellazione di un singolo prodotto. */
    private static final String DELETE_QUERY = "DELETE FROM aggiunto WHERE prodotto = ? AND utente = ? ";
    
    private static final String DELETE_ONE = "UPDATE aggiunto SET quantità = quantità - 1 WHERE prodotto = ? AND utente = ?";
    
    private static final String DELETE_GAME = "DELETE FROM prodotto WHERE titolo = ?";
    
    private static final String LIST_QUERY = "SELECT titolo, sum(quantità) as quantità FROM aggiunto inner join prodotto on prodotto = idprodotto WHERE utente = ? GROUP BY (titolo)";

    
	@Override
	public List<Prodotto> getAllProdotto() {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Prodotto prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY);
        	statement.execute();
        	result = statement.getResultSet();
        	
        	while(result.next()) {
        		prodotto = new Prodotto(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5), result.getString(6),result.getString(7));
        		prodotto.setPath("Cover/"+ prodotto.getIdprodotto() + ".jpg");
        		prodotti.add(prodotto);
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
		
		return prodotti;
	}

	@Override
	public int getProdotto(int id_utente, int id_prodotto) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		 try {
	            con = MySQLDAO.createConnection();
	            statement = con.prepareStatement(READ_QUERY);
	            statement.setInt(1, id_utente);
	            statement.setInt(2, id_prodotto);

	            statement.execute();
	            result = statement.getResultSet();
	 
	            if (result.next() && result != null) {
	            	return 1;
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
	 	
		return 0;
	}

	@Override
	public int createProdotto(Prodotto prodotto) {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, prodotto.getTitolo());
            statement.setInt(2, prodotto.getPrezzo());
            statement.setString(3, prodotto.getPiattaforma());
            statement.setString(4, prodotto.getGenere());
            statement.setString(5, prodotto.getAnno());
           
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
	public boolean updateProdotto(int id_prodotto, String titolo, int prezzo, String piattaforma, String genere, String anno) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
        	con = MySQLDAO.createConnection();
        	statement = con.prepareStatement(UPDATE_QUERY);
        	statement.setString(1, titolo);
            statement.setInt(2, prezzo);
            statement.setString(3, piattaforma);
            statement.setString(4, genere);
            statement.setString(5, anno);
            
            statement.setInt(6, id_prodotto);
            
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
	public boolean deleteProdotto(String titolo) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(DELETE_GAME);
            statement.setString(1, titolo);
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
	public List<Prodotto> getProdottiSpecifici(String genere) {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Prodotto prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
        try {
        	con = MySQLDAO.createConnection();
        	statement = con.prepareStatement(READ_ALL_QUERY_SPECIFIED);
        	statement.setString(1, genere);
        	statement.execute();
        	result = statement.getResultSet();
        	
        	while(result.next()) {
        		prodotto = new Prodotto(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(6), result.getString(6),result.getString(7));
        		prodotto.setPath("Cover/"+ prodotto.getIdprodotto() + ".jpg");
        		prodotti.add(prodotto);
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
		
		return prodotti;
	}
	
	public int addGameUser(int utente, int quantità, int prodotto) {
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(INSERT_QUERY_USER);
			statement.setInt(1, utente);
			statement.setInt(2, quantità);
			statement.setInt(3, prodotto);
			
			statement.execute();
			return 1;

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
		
		return 0;
	}

	public int updateGameUser(int utente, int quantità, int prodotto) {
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(UPDATE_QUERY_USER);
			statement.setInt(1, quantità);
			statement.setInt(2, utente);
			statement.setInt(3, prodotto);
			
			statement.execute();
			
			return 1;
			
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
		
		
		return 0;
	}
	
	public int ceckVolume(int utente, int prodotto) {
		Connection con = null;
		PreparedStatement statement =null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(READ_QUERY_VOLUME);
			
			statement.setInt(1, prodotto);
			statement.setInt(2, utente);
			
			statement.execute();
			
			result = statement.getResultSet();
			
			while(result.next()) {
				return result.getInt(1);
			}

			
		}catch (SQLException e) {
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
		
		return -1;
	}
	
	public int removeGameOne(int utente, int prodotto) {
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(DELETE_ONE);
			
			statement.setInt(1, prodotto);
			statement.setInt(2, utente);
			
			statement.execute();
			
			return 1;

			
		}catch (SQLException e) {
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
		
		
		
		return 0;
		
	}
	
	public int removeGameUser(int utente, int prodotto) {
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(DELETE_QUERY);
			
			statement.setInt(1, prodotto);
			statement.setInt(2, utente);
			
			statement.execute();
			
			return 1;

			
		}catch (SQLException e) {
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
		
		
		return 0;
	}
	
	public List<Prodotto> gameUserList(int id_utente){
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Prodotto prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(LIST_QUERY);
			statement.setInt(1, id_utente);
			
			statement.execute();
			
			result = statement.getResultSet();
			
			while(result.next()) {
				prodotto = new Prodotto(result.getString(1), result.getInt(2));
        		prodotti.add(prodotto);
			}
			
			return prodotti;
			
		}catch (SQLException e) {
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
		return null;
	}

	public Prodotto searchTitle(String titolo) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(READ_QUERY_TITLE);
			
			statement.setString(1, titolo);
			
			statement.execute();
			
			result = statement.getResultSet();
			 while(result.next()) {
				 return new Prodotto(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5), result.getString(6));
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
		
		return null;
	}

}
