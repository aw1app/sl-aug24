package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);// 
		
		
		if(session!=null) {	
			
			out.println("Welcome User. I think you first went to Home and then have come to me. ");
			out.println("<br> We are tracking you. SessionId : " + session.getId());		
			
		}else {
			out.println("Welcome User. Looks like you directly came to me.");
			out.println("<br> <br> <a href=\"HomeServlet\">Go to Home Page</a>");
		}
		
		out.close();
		
	}
}