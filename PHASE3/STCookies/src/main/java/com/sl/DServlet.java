package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		boolean sessIdCookieExist=false; 
		String sessIdCookieValue =null;
		
		if(cookies!=null)
			for(Cookie cookie : cookies) {
				String nameOfCookie = cookie.getName();
				
				if(nameOfCookie.equals("sessIdStr")) {
					sessIdCookieExist=true;
					sessIdCookieValue = cookie.getValue();
					break;
				}				
			}
		
		if (sessIdCookieExist == false) {
			out.println("Welcome User. Looks like you directly came to me without going to Homeservlet.");
		}else {
			out.println("Welcome User. I think you first went to Home and then have come to me. " +
		   "Your sesssion ID is " + sessIdCookieValue );
			out.println("<br> We are tracking you.");	
		};		
		
		
	}
}