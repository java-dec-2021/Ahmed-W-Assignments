<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Insert title here</title>
</head>
<body>
	
	<div class="container col-6">
	<h1>${dojos.name} Ninjas</h1>
	
	<table class="table table-striped">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<tbody>
			<c:forEach items="${dojos.ninjas}" var="dojo">
			<tr>
				<td>${dojo.firstName}</td>
				<td>${dojo.lastName}</td>
				<td>${dojo.age}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>
</body>
</html>