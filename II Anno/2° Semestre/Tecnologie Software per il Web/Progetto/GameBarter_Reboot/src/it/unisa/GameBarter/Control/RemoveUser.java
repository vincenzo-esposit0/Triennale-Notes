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
 * Servlet implementation class RemoveUser
 */
@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUser() {
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

			Utente utente =  (Utente) session.getAttribute("user");
			String titolo = request.getParameter("titolo");

			List<Prodotto> prodotti = prodotto.getAllProdotto();
			int id_prodotto = 0;
			
			for(Prodotto e : prodotti) {
				if(e.getTitolo().compareToIgnoreCase(titolo) == 0)
					id_prodotto = e.getIdprodotto();
			}
			
			prodotto.removeGameOne(utente.getIdutente(), id_prodotto);
			
			if(prodotto.ceckVolume(utente.getIdutente(), id_prodotto) == 0) {
				prodotto.removeGameUser(utente.getIdutente(), id_prodotto);
			}
			
			request.getRequestDispatcher("utente.jsp").forward(request, response);
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
