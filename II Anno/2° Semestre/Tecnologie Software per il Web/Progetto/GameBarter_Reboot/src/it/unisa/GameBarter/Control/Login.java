package it.unisa.GameBarter.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.GameBarter.DAO.MySQLUtenteDAO;
import it.unisa.GameBarter.Model.Utente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		synchronized(session) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address;
			
			MySQLUtenteDAO data = new MySQLUtenteDAO();
			
			List<Utente> utenti = data.getAllUtenti();
			
			Utente user = null;
			
			for(Utente e : utenti) {
				if(e.getUsername().compareToIgnoreCase(username) == 0
						&& e.getPassword().compareToIgnoreCase(password) == 0) {
					
					user = e;
				}
			}
			
			boolean logged;
			boolean wrong;
			
			session.setAttribute("user", user);
			
			
			if(user != null) {
				logged = true;
				session.setAttribute("isLog", logged);
				session.setAttribute("isAdmin", user.isAdmin());
				address = "utente.jsp";
				if(user.isAdmin()) {
					address = "admin.jsp";
				}
				request.getRequestDispatcher(address).forward(request, response);
			}
			
			else{
				wrong = true;
				session.setAttribute("isWrong", wrong);
				address = "login.jsp";
				request.getRequestDispatcher(address).forward(request, response);
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
