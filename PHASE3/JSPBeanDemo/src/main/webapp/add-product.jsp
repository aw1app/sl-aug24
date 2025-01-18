<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br>
<p></p>
This part if you want to capture individual form paramters.
</p>
<jsp:useBean id="product1" class="com.ecommerce.EProduct" scope="page">

</jsp:useBean>

<jsp:setProperty property="*" name="product1" />




   
 <br> <br> Name  <%=product1.getName() %>