<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<td align="center">
	<p>List of Students</p>
	<table border=1>
		<tr>
			<th>ID
			<th>FISRT_NAME
			<th>LAST_NAME
			
		</tr>

		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.studentId}
				<td>${student.firstName}
				<td>${student.lastName}
			</tr>
		</c:forEach>


		<br>
		<br>
		
		<br><br>
<a href="/index.jsp" > Back to HOME</a>