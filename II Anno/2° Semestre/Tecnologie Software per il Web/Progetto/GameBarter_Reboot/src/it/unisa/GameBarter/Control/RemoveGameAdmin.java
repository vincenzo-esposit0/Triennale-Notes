package it.unisa.GameBarter.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.unisa.GameBarter.DAO.MySQLProdottoDAO;
import it.unisa.GameBarter.DAO.ProdottoDAO;


/**
 * Servlet implementation class RemoveGameAdmin
 */
@WebServlet("/RemoveGameAdmin")
public class RemoveGameAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveGameAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoDAO prodotto = new MySQLProdottoDAO();

		String titolo = request.getParameter("titolo");
		
		prodotto.deleteProdotto(titolo);
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
