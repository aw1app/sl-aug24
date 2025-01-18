<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div style="text-align: right;">
<jsp:include page="header.jsp"></jsp:include>
</div>

<sql:setDataSource var="ecommerce" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:query dataSource="${ecommerce}" var="resultSet">
	
	SELECT * FROM eproducts where ProductID=<%=request.getParameter("ID")%>

</sql:query>



<c:forEach var="row" items="${resultSet.rows}">

	<form action="save-edited-product.jsp" method="post">

		<br><input name="ID" value="${row.productID}" type="hidden"> <br>
		<br>Name: ${row.productName } <br>
		<br>Price: <input name="price" value="${row.price}"> <br>
		<br>Category: <input name="Category" value="${row.Category}">

		<br>
		<br>
		<input type="submit" value="Submit">

	</form>

</c:forEach>