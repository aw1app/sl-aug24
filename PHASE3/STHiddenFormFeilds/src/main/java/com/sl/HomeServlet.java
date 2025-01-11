package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Random random = new Random();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside HomeServlet  doGet");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String sessIdStr = request.getParameter("sessIdStr");

		if (sessIdStr == null) {
			int newSessId = random.nextInt();

			out.println("<html><form action='DServlet' method='POST'>");
			out.println("<input type='hidden' name='sessIdStr' value='" + newSessId + "'>");
			out.println("<input type='submit' value='submit' >");
			out.println("</form>");
			out.println("<script>document.forms[0].submit();</script></html>");
			

		} else {
			out.println("<p>  <a href='DServlet?sessIdStr=" + sessIdStr + "' >Go to Dashboard </a>"); // Go to Dashboard
																									// servlet
		}

		out.close();

		
	}

}
