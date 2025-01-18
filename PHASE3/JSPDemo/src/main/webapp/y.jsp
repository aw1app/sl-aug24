<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h2>this is index page</h2>
	<jsp:forward page="z.jsp" />
	
	<% out.print ("y.jsp : Today is:"+java.util.Calendar.getInstance().getTime()); %>

</body>
</html>

