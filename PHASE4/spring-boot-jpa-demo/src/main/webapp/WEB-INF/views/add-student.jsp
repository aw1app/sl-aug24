<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<form:form action="add-student" method="post" modelAttribute="student">


	<form:label path="firstName">First name:</form:label>
	<form:input path="firstName" />
	<br />


	<form:label path="lastName">Last name:</form:label>
	<form:input path="lastName" />
	<br />


	<form:label path="dateOfBirth">DOB:</form:label>
	<form:input path="dateOfBirth" />
	<br />


	<form:label path="enrollmentDate">Enrollment Date:</form:label>
	<form:input path="enrollmentDate" />
	<br />


	<form:label path="sessionName">Session name:</form:label>
	<form:input path="sessionName" />
	<br />

	<br />


	<form:button>Add Student</form:button>



</form:form>