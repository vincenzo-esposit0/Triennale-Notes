package it.unibo.tw.web.servlets;

import it.unibo.tw.web.beans.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.jabsorb.JSONSerializer;
import org.jabsorb.serializer.MarshallException;

public class JSONServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	  /*
	   * l'oggetto che ci permettera'� di serializzare/de-serializzare i parametri
	   */
	JSONSerializer serializer;
	
	@Override
	public void init() {
		FeedDb feedDb = (FeedDb)this.getServletContext().getAttribute("feedDb");
		if ( feedDb == null ){
			// creiamo un novo FeedDb solo se non esiste ancora
			feedDb = new FeedDb();
			this.getServletContext().setAttribute("feedDb", feedDb);
		}
		
		serializer = new JSONSerializer();
	    try {
	    	// inizializza i tipi serializzatori forniti di default 
	    	serializer.registerDefaultSerializers(); 
	    } 
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	e.printStackTrace();
	    }
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
	throws ServletException, IOException {
		// recupero il tipo di categoria cercata dai parametri della richiesta
		String category = request.getParameter("category");

		// recupero i feed corrispondenti dal database (implementato come Java Bean)
		FeedDb feedDb = (FeedDb)this.getServletContext().getAttribute("feedDb");
		List<Feed> feeds = feedDb.find(category);

		// li stampo su out
		try {
			response.getWriter().println(serializer.toJSON(feeds.toArray(new Feed[0])));
		}
		catch (MarshallException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
