package com.example.web;

import java.io.*;
import com.example.model.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

/** Servlet that prints out the Beers of the selected color</a>.
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
	  request.setAttribute("styles", result);
	  RequestDispatcher view = request.getRequestDispatcher("result.jsp");
	  view.forward(request, response);
	  }
	 }

