<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>

<h1>STUDENT LIST</h1>

<c:forEach var="student" items="${students}" >

 ${student.firstName}, ${student.lastName}, ${student.dateOfBirth}, ${student.enrollmentDate}, ${student.sessionName}<br>
</c:forEach>


