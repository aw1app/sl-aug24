<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<td align="center">
	<p>List of Students</p>
	<table border=1>
		<tr>
			<th>ID
			<th>FISRT_NAME
			<th>LAST_NAME
			<th>DETAILS
			<th>DELETE
			
		</tr>

		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.studentId}
				<td>${student.firstName}
				<td>${student.lastName}
				<td><a href="details?id=${student.studentId}"> SHOW DETAILS </a>
				<td><a href="delete?id=${student.studentId}"> DELETE </a>
			</tr>
		</c:forEach>


		<br>
		<br>
		
		<br><br>
<a href="/index.jsp" > Back to HOME</a>