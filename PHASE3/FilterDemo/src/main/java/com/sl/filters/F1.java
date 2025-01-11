package com.sl.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

public class F1 extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		// place your business logic code here
		System.out.println("Inside f1  doFilter");

		if (Integer.parseInt(request.getParameter("age")) < 18) {
			out.println("<br>You are not eleigible to vote.");			
		}else {

		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

}
