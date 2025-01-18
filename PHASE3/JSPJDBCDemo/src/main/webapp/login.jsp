<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>

<%

String username = request.getParameter("username");
String password = request.getParameter("password");

if (username.equals("admin") && password.equals("admin123")) {
	
	session.setAttribute("logged", true);
	
	response.sendRedirect("list-products.jsp");
	
} else {
	out.print("INVALID USER/PASSWORD ! LOGIN AGAIN");
	out.print("<a href=\"index.jsp\"> HOME </a>");
}
%>


%>
