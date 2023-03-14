package it.unisa.GameBarter.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import it.unisa.GameBarter.DAO.MySQLProdottoDAO;
import it.unisa.GameBarter.DAO.ProdottoDAO;
import it.unisa.GameBarter.Model.Prodotto;

/**
 * Servlet implementation class ModifyGameAdmin
 */
@WebServlet("/ModifyGameAdmin")
public class ModifyGameAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyGameAdmin() {
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
			Prodotto p = null;
			
			String titolo = request.getParameter("titolo");
			
			p = prodotto.searchTitle(titolo);
			
			session.setAttribute("product", p);
			
			request.getRequestDispatcher("modifica.jsp").forward(request, response);
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
