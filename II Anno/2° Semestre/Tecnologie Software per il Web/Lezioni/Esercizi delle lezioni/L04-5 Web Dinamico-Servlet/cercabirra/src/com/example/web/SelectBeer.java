package com.example.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that prints out the Beers of the selected color</a>. */

@WebServlet("/SelectBeer")
public class SelectBeer extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) 
							  throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Beer Selection Advice<br>");
		
		String c = request.getParameter("color");
		
		out.println("<br>Got beer color " + c);
	}
}


