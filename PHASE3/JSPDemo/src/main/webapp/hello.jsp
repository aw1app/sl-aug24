<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>

	<h1>Welcome to EStore</h1>

	<%=new java.util.Date()%>

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


<%! Product p1 = new Product("HP Mouse",25.5f); %>
<br> Price of the Product of the day : <%= p1.getPrice() %>

</body>
</html>