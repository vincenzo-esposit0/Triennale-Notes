package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that prints out the firstname and lastname
 */

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Name and Surname";
    String docType =
      "<!html>\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>FirstName</B>: "
                + request.getParameter("firstName") + "\n" +
                "  <LI><B>LastName</B>: "
                + request.getParameter("lastName") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }
}
