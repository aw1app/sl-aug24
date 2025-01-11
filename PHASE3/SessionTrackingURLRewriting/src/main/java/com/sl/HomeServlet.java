package com.sl;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Random;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Random random = new Random();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside HomeServlet  doGet");

		PrintWriter out = response.getWriter();

		String sessIdStr = request.getParameter("sessIdStr");

		if (sessIdStr == null) {
			int newSessId = random.nextInt();

			// Let's add the sessId to the ServletContext so that we can implement
			// something like a ShoppingCart functionality

			out.println("<p>  <a href='DServlet?sessIdStr=" + newSessId + "' >Go to Dashboard </a></p>"); // Go to Dashboard
																									// servlet

		} else {
			out.println("<p>  <a href='DServlet?sessIdStr=" + sessIdStr + "' >Go to Dashboard </a>"); // Go to Dashboard
																									// servlet
		}

		out.close();
	}

}
