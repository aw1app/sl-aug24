<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<td align="center"><c:if test="${courses!=null}">
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
			</c:if>

			<c:if test="${courses==null}">
No courses to display
<c:if test="${hasError==true}">Try again later</c:if>
			</c:if>

			<br>
			<br>

			<br>
			<br>
			<a href="/index.jsp"> Back to HOME</a>