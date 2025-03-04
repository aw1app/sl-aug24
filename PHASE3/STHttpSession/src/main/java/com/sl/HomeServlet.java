package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet( request,  response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// .getSession(true) true means create a new session object if a http session object was never created 
		// for this user
		HttpSession session = request.getSession(true);
		
		
		String item = request.getParameter("item");
		
		Cart myCart = (Cart) session.getAttribute("cart");
		
		if(myCart==null)
		myCart = new Cart();
		
		myCart.items.add(item);
		
		session.setAttribute("cart", myCart);
			
		out.println("<p>  <a href='DServlet' >Go to Dashboard </a>");
		out.close();
	}
    

}