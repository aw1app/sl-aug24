<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<td align="center">
	<p>List of Courses</p>
	<table border=1>
		<tr>
			<th>ID
			<th>NAME
			<th>VIEW DETAILS
			
		</tr>

		<c:forEach var="course" items="${courses}">
			<tr>
				<td>${course.id}
				<td>${course.name}
				<td><a href="/display-course/${course.id}"> SHOW DETAILS </a>
			</tr>
		</c:forEach>


		<br>
		<br>
		
		<br><br>
<a href="/index.jsp" > Back to HOME</a>