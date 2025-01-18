<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="ecommerce" driver="com.mysql.cj.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />
	

<sql:query dataSource="${ecommerce}" var="resultSet">
	SELECT * FROM eproducts
</sql:query>	


<br>LIST OF PRODUCT <br>
<table border=1>
	<tr style="background-color:lightgrey">
		<th>ID
		<th>NAME
		<th>PRICE
		<th>CATEGORY
		<th>DELETE
	</tr>

	<c:forEach var="row" items="${resultSet.rows}">
		<tr>
			<td>${row.productID }
			<td>${row.productName }
			<td> ${row.price}
			<td>${row.category }
			<td><a href="delete-product.jsp?ID=${row.productID}"> DELETE </a>
		</tr>
	</c:forEach>

</table>
