<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>

	<h1><center>Welcome to EStore</center></h1>

	<!-- Expressions Demo -->
	<%=new java.util.Date()%>

	<!-- Declaration Demo -->
	<%!
	int x = 100;
	int y = 200;
	%>

	<%!
	class Product {
	String name;
	float price;
	
	Product(String name,float price){
		this.name=name;
		this.price=price;
	}
	
	public float getPrice(){
		return this.price;
	}
	
	};
	
	%>

<!-- Declaration Demo -->
<%! Product p1 = new Product("HP Mouse",25.5f); %>
<!-- Expressions Demo -->
<br> Price of the Product of the day : <%= p1.getPrice() %>

CHALLENGE : Display name of the product.

</body>
</html>