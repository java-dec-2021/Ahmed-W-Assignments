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
	<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<div class="container col-4">
	<form:form method="POST" action="/processdojo" modelAttribute="dojo">
		<div class="form-group row">
			<div>
			
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
			</div>
		</div>
		<button class="my-3 btn btn-success">Create</button>
	</form:form>
	
	</div>
	
	<a href="/ninja">Create Ninja</a>
</body>
</html>