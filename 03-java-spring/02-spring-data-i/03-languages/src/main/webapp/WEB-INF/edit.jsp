<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<nav class="navbar navbar-light bg-light">
 		 <span><a href="/delete">Delete</a></span>
 		 <span><a href="/languages">Dashboard</a></span>
	</nav>
	
	<div class="container">
		
		<form:form action="/update/${language.id}" method="post" modelAttribute="language">
	    <input type="hidden" name="id" value="${language.id}">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name" value="${language.name}"/>
	        
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p>
	       
	    <input type="submit" value="Submit"/>
	</form:form>   
		
	</div>
</body>
</html>