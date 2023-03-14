package it.unisa.GameBarter.Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.GameBarter.DAO.MySQLProdottoDAO;
import it.unisa.GameBarter.DAO.ProdottoDAO;
import it.unisa.GameBarter.Model.CartProdotto;
import it.unisa.GameBarter.Model.Prodotto;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		synchronized(session) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean presenteinLista = false;

			ProdottoDAO prodotto = new MySQLProdottoDAO();
			List<Prodotto> prodotti = prodotto.getAllProdotto();
			
			@SuppressWarnings("unchecked")
			List<CartProdotto> cartList = (List<CartProdotto>) session.getAttribute("cart");
			if(cartList == null) {
				cartList = new ArrayList<CartProdotto>();
			}
			
			Boolean isLogged = (Boolean) session.getAttribute("isLog");
			
			if(isLogged != null) {

				for(Prodotto e : prodotti) {
					if(e.getIdprodotto() == id) {
						for(CartProdotto x : cartList) {
							if(x.getIdprodotto() == id) {
								presenteinLista = true;
								x.setVolume((x.getVolume() + 1));
							}
						}
						if(!presenteinLista) {
							cartList.add(new CartProdotto(e.getIdprodotto(), e.getTitolo(), e.getPrezzo(), 1, e.getPiattaforma()));
						}
					}
				}
				

				
				session.setAttribute("cart", cartList);
				request.getRequestDispatcher("index.jsp").forward(request, response);	
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);	
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
