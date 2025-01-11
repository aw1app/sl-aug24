package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String sessIdStr = request.getParameter("sessIdStr");
		
		if(sessIdStr!=null) {	
			
			out.println("Welcome User. I think you first went to Home and then have come to me. ");
			out.println("<br> We are tracking you.");		
			
		}else {
			out.println("Welcome User. Looks like you directly came to me.");
			out.println("<br> <br> <a href=\"HomeServlet\">Go to Home Page</a>");
		}
		
	}
}