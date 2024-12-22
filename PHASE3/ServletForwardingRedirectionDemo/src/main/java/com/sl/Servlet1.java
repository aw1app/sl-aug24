package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Servlet1  doGet");
	
		PrintWriter out = response.getWriter();
		
		out.println("<br>1. This is output from Servlet 1");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/S2");

		dispatcher.include(request, response);

		out.println("<br>2. This is output from Servlet 1");
		
		out.close();
		
		
	}

}
