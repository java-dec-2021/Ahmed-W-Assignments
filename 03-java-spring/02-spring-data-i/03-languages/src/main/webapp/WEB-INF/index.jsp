<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container">
	<table class="table table-striped my-5">
		<thead class="table-dark">
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="language" items ="${languages}">
			<tr>
				<td><c:out value="${language.name}"/></td>
				<td><c:out value="${language.creator}"/></td>
				<td>${language.version}</td>
				<td><a href="/languages/${language.id}">View</a>  |  <a href="/delete/${language.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action="/validate" method="post" modelAttribute="language">
	    <div class="mb-3 row">
	        <form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
	        <form:errors path="name"/>
	        <div class="col-sm-4">
	        
	        <form:input path="name" class="form-control"/>
	        </div>
	    </div>
	    <div class="mb-3 row">
	        <form:label path="creator" class="col-sm-2 col-form-label">Creator</form:label>
	        <form:errors path="creator"/>
	        <div class="col-sm-4">
	        
	        <form:input path="creator" class="form-control"/>
	        </div>
	    </div>
	    <div class="mb-3 row">
	        <form:label path="version" class="col-sm-2 col-form-label">Version</form:label>
	        <form:errors path="version"/>
	        <div class="col-sm-4">
	        <form:input path="version" class="form-control"/>
	        
	        </div>
	    </div>
	       
	    <input type="submit" value="Submit"/>
	</form:form>    
	</div>
	
	
	
</body>
</html>