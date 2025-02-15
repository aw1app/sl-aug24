<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${student != null }">

	<p>Details of the Student with id ${student.studentId}</p>
	<table border=1>
		<tr>
			<th>ID
			<th>FISRT_NAME
			<th>LAST_NAME
			<th>DOB
			<th>Enrollment Date
			<th>SESSION NAME
		</tr>


		<tr>
			<td>${student.studentId}
			<td>${student.firstName}
			<td>${student.lastName}
			<td>${student.dateOfBirth}
			<td>${student.enrollmentDate}
			<td>${student.sessionName}
		</tr>

	</table>
</c:if>

<c:if test="${student == null }"> No such Student with the given id !! </c:if>

<br>
<br>

