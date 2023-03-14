package it.unisa.GameBarter.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.GameBarter.DAO.MySQLProdottoDAO;
import it.unisa.GameBarter.DAO.ProdottoDAO;
import it.unisa.GameBarter.Model.Prodotto;
import it.unisa.GameBarter.Model.Utente;

/**
 * Servlet implementation class AddGameUser
 */
@WebServlet("/AddGameUser")
public class AddGameUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		synchronized(session) {
			ProdottoDAO prodotto = new MySQLProdottoDAO();

			int q = Integer.parseInt(request.getParameter("volume"));
			Utente utente =  (Utente) session.getAttribute("user");
			String titolo = request.getParameter("titolo");
			
			
			List<Prodotto> prodotti = prodotto.getAllProdotto();
			int id_prodotto = 0;
			
			for(Prodotto e : prodotti) {
				if(e.getTitolo().compareToIgnoreCase(titolo) == 0)
					id_prodotto = e.getIdprodotto();
			}
			
			if((int) prodotto.getProdotto(utente.getIdutente(), id_prodotto) == 1) {
				prodotto.updateGameUser(utente.getIdutente(), q, id_prodotto);
				request.getRequestDispatcher("utente.jsp").forward(request, response);
				
			}
			else {
				prodotto.addGameUser(utente.getIdutente(), q, id_prodotto);
				request.getRequestDispatcher("utente.jsp").forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

