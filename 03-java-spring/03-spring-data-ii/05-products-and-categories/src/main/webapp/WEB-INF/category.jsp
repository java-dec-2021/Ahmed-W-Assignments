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
	<title>New Category</title>
</head>
<body>
	<div class="container col-4">
		<h1>New Category</h1>
		<form:form method="POST" action="processcategory" modelAttribute="category">
			<div class="form-group row">
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name"/>
			</div>
			<button class="my-3 btn btn-success">Create</button>
		</form:form>
		
		<a href="/">Create Product</a>
	</div>
</body>
</html>