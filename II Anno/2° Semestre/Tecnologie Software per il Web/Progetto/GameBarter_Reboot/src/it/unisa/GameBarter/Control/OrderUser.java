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

import it.unisa.GameBarter.Model.Utente;
import it.unisa.GameBarter.DAO.MYSQLOrdine;
import it.unisa.GameBarter.DAO.OrdineDAO;
import it.unisa.GameBarter.Model.Ordine;


/**
 * Servlet implementation class OrderUser
 */
@WebServlet("/OrderUser")
public class OrderUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		synchronized(session) {
		
			Utente user = (Utente) session.getAttribute("user");
			OrdineDAO ordine =  new MYSQLOrdine();
			List<Ordine> acquisti = new ArrayList<Ordine>();
			
			acquisti = ordine.acquisti(user);
			
			System.out.println(acquisti.size());
			
			PrintWriter out = response.getWriter();
			
			String json = new Gson().toJson(acquisti);
			
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
