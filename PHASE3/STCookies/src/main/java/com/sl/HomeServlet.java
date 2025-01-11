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

		
		Cookie[] cookies = request.getCookies();
		
		boolean sessIdCookieExist=false; // variable to track if browser-session related cookie is already present in the request

		if(cookies!=null)
			for(Cookie cookie : cookies) {
				String nameOfCookie = cookie.getName();
				
				if(nameOfCookie.equals("sessIdStr")) {
					sessIdCookieExist=true;
					break;
				}				
			}
		
		if (sessIdCookieExist == false) {
			int sessId = random.nextInt();
			Cookie sessIdCookie = new Cookie("sessIdStr",""+sessId );
			response.addCookie(sessIdCookie);
		}else {
			out.println("Welcome User.");
			out.println("<br> We are tracking you.");
			out.println("<p>  <a href='DServlet' >Go to Dashboard </a>"); 
		};			
		
		out.close();
	}

}
