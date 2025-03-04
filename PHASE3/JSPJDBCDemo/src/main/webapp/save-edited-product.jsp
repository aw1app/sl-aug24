<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="ecommerce" driver="com.mysql.cj.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />
	
	<sql:update dataSource="${ecommerce}" var="count">
	
	UPDATE eproducts SET price=<%=request.getParameter("price") %>, Category='<%=request.getParameter("Category") %>'
	WHERE ProductID=<%=request.getParameter("ID") %>
	
	</sql:update>
	
	<c:out value="${count}" /> product(s) inserted successfully!
	
	<c:redirect url="list-products.jsp"></c:redirect>