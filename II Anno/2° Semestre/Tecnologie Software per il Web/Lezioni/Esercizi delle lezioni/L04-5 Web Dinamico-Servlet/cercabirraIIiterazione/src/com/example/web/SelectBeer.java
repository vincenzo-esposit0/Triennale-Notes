package com.example.web;

import java.io.*;
import com.example.model.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

/**
 * Servlet that prints out the Beers of the selected color</a>.
 */

@WebServlet("/SelectBeer")
public class SelectBeer extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response)
							  throws ServletException, IOException {
		String c = request.getParameter("color");
		
		BeerExpert be = new BeerExpert();
		List<String> result = be.getBrands(c);
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("Beer Selection Advice<br>");
		Iterator<String> it = result.iterator();
		while (it.hasNext()) {
			out.print("<br>try: " + it.next());
		}
	}
}
