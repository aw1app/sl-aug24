package com.sl;

import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
		System.out.println("Inside init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		System.out.println("Inside doGet");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		System.out.println("Inside doPost");

		out.close();
	}
	
	public void destroy() {
		System.out.println("Inside destroy() ");
	}

}
