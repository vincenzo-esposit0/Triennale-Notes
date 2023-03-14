package it.unisa.GameBarter.Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import it.unisa.GameBarter.DAO.MYSQLOrdine;
import it.unisa.GameBarter.DAO.MySQLProdottoDAO;
import it.unisa.GameBarter.DAO.MySQLUtenteDAO;
import it.unisa.GameBarter.DAO.OrdineDAO;
import it.unisa.GameBarter.DAO.ProdottoDAO;
import it.unisa.GameBarter.Model.CartProdotto;
import it.unisa.GameBarter.Model.Prodotto;
import it.unisa.GameBarter.Model.Utente;

/**
 * Servlet implementation class Ordine
 */
@WebServlet("/Ordine")
public class Ordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		synchronized(session) {
			@SuppressWarnings("unchecked")
			List<CartProdotto> cartList = (List<CartProdotto>) session.getAttribute("cart");
			Utente user=(Utente) session.getAttribute("user");
			
			if(cartList == null) {
				cartList = new ArrayList<CartProdotto>();
			}
			
			List<String> nonDisponibili = new ArrayList<String>();
			
			String result = "";
			
			OrdineDAO ordine = new MYSQLOrdine();
			ProdottoDAO prodotto = new MySQLProdottoDAO();
			List<Prodotto> prodotti = prodotto.getAllProdotto();

			int  totale = 0;
			
			if(cartList.size() == 0 ) {
				result = "Carrello vuoto";
			}else {
				for(CartProdotto e : cartList) {
					for(Prodotto x : prodotti) {
						if(e.getIdprodotto() == x.getIdprodotto()) {
							if(e.getVolume() > x.getVolume()) {
								nonDisponibili.add(x.getTitolo());
							}
						}
					}
				}
				
			}
			
			if(nonDisponibili.size() > 0) {
				for(String e : nonDisponibili) {
					result = result + e + ", ";
				}
				result = result + "quantità non disponibile per il prodotto selezionato";
			}else if(cartList.size() >= 1){
				
				for(CartProdotto e : cartList) {
					totale = totale + e.getPrezzo() * e.getVolume();
				}
				
				if (user.getValuta() < totale) {
					result = "BR insufficienti, ordine non creato";
				}else {
					result = "Ordine creato";
					
					ordine.creazioneOrdine(user.getIdutente(), totale, cartList);
					
		
					cartList.removeAll(cartList);
				}
			}
			
			PrintWriter out = response.getWriter();

			String json = new Gson().toJson(result);
			
			MySQLUtenteDAO data = new MySQLUtenteDAO();
			
			List<Utente> utenti = data.getAllUtenti();
			
			
			for(Utente e : utenti) {
				if(e.getUsername().compareToIgnoreCase(user.getUsername()) == 0
						&& e.getPassword().compareToIgnoreCase(user.getPassword()) == 0) {
					user = e;
				}
			}
			
			session.setAttribute("user", user);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();

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
