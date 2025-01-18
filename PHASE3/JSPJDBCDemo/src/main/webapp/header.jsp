<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>

<div style="text-align: right;">
<span>
	<a href="add-product.html"> Add Product</a></span>
 | 	
<span><a href="list-products.jsp">List Products</a></span>
| 

<% if (session==null || session.getAttribute("logged")==null || (boolean) session.getAttribute("logged") == false ) { %>
<span>	<a href="login.html"> LOGIN </a></span>
<% } %>

 | 
 
 <% if (session!=null && session.getAttribute("logged")!=null && (boolean) session.getAttribute("logged") == true ) { %>
<span>	<a href="logout.jsp"> LOGOUT </a></span>
<% } %>

</div>