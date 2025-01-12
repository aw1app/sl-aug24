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

	<%!class Product {
String name;
float price;

Product(String name, float price) {
this.name = name;
this.price = price;
}

public float getProductPrice() {
return this.price;
}

public String getProductName() {
return this.name;
}
}%>

<%! Product prod = new Product("HP Laptop", 155.55f);
String prodName = prod.getProductName();
float prodPrice = prod.getProductPrice();
%>
<br><br>Product Name: <%= prodName %> <br>
<br>Product Price: <%= prodPrice %>

<br><br>CHALLENGE : Display name of the product.

<!-- Scriptlet Demo -->
<br><br>
<!-- Approach 1 -->
<% 
for(int i=0;i<5;i++){
	out.println("<br>"+i*i);
}
%>


<!-- Approach 2 -->
<br><br>
<% for(int i=0;i<5;i++){ %>	
	<br><%= i*i %> 
<% } %>	



</body>
</html>