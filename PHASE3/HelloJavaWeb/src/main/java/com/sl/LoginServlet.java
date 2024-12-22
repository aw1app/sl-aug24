package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Access some headers sent by the browser
		String userAgent = request.getHeader("User-Agent");
		System.out.println("userAgent : "+ userAgent);
		String encoding = request.getHeader("Accept-Encoding");
		System.out.println("Accept-Encoding : "+ encoding);
		
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		
		// Get the phone number from form as integer
		String phoneStr = request.getParameter("phone");
		long phone = Long.parseLong(phoneStr);
		
		//Process donation, which is a multivalued checkbox form feild
		String[] donations = request.getParameterValues("donate");
		
		
		out.println("Hey " + name + "Welcome to SL." + "You have donated " +Arrays.toString(donations));
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		
		// Get the phone number from form as integer
		String phoneStr = request.getParameter("phone");
		long phone = Long.parseLong(phoneStr);
		
		//Process donation, which is a multivalued checkbox form feild
		String[] donations = request.getParameterValues("donate");
		
		
		out.println("Hey " + name + "Welcome to SL." + "You have donated " +Arrays.toString(donations));
		out.close();
	}

}

//CHALLENGE: Enhance above servlet so that it prints "You have successfully logged in" if password is "abc123"
//otherwise print "Invalid username/password. Login again"
