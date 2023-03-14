package it.unisa.GameBarter.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.GameBarter.Model.CartProdotto;

/**
 * Servlet implementation class Add_one
 */
@WebServlet("/Add_one")
public class Add_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_one() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		synchronized(session) {
			String titolo = request.getParameter("titolo");
			@SuppressWarnings("unchecked")
			List<CartProdotto> cartList = (List<CartProdotto>) session.getAttribute("cart");
				
			for(CartProdotto e : cartList) {
				if(e.getTitolo().compareToIgnoreCase(titolo) == 0)
					e.setVolume((e.getVolume() + 1));
			}
			
			session.setAttribute("cart", cartList);
			request.getRequestDispatcher("carrello.jsp").forward(request, response);	
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
