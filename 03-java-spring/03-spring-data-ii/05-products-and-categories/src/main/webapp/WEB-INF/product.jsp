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
	<title>New Product</title>
</head>
<body>
	<div class="container col-4">
		<h1>New Product</h1>
		<form:form method="POST" action="processproduct" modelAttribute="product">
			<div class="form-group row">
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name"/>
			</div>
			<div class="form-group row">
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:input path="description"/>
			</div>
			<div class="form-group row">
				<form:label path="price">Price</form:label>
				<form:errors path="price" />
				<form:input path="price"/>
			</div>
			<button class="my-3 btn btn-success">Create</button>
		</form:form>
		
		<a href="/category">Create Category</a>
		
	</div>
</body>
</html>