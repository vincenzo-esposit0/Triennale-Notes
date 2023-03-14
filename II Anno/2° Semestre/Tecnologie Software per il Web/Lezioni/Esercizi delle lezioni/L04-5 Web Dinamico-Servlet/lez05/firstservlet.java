package lez05;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class firstservlet
 */
@WebServlet("/firstservlet")
public class firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter(); 
		java.util.Date today = new java.util.Date(); 
		out.println("<html> " +"<body>"+"<h1 align=center> Lez05 Servlet </h1>"
				+ "<br>" + today + "</body>" + "</html>");
	}
}

	
	


