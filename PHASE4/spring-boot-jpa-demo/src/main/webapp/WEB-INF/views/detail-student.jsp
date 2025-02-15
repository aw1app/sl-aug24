<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<td align="center">
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
		


		<br>
		<br>
		
	