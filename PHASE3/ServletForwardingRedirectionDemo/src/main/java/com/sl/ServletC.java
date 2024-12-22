package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside ServletC  doGet");

		PrintWriter out = response.getWriter();

		out.println(" This is output from Servlet C");

		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/SZ");

		dispatcher.forward(request, response);
		
		
		out.close();

	}

}
