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
	<title>Category Page</title>
</head>
<body>
	<div class="container col-4">
		<h1 class="my-3">${product.name}</h1>
		<div>
			<h3 class="my-3">Categories:</h3>
			<c:forEach items="${product.categories}" var="category">
				<p>- ${category.name}</p>
			</c:forEach>
				
		</div>
		
			
		<form method="POST" action="/product/${product.id}/addcategory">
			<label>Select a category:</label>
			<select name="category">
				<c:forEach items="${category}" var="cat">
					<option value="${cat.id}">${cat.name}</option>
				</c:forEach>
			</select>
			<button class="btn btn-warning">Add</button>
		</form>
		
		<p class="mt-5">
			<a href="/">Create Product</a>
		</p> 
		<a href="/category">Create Category</a>
	</div>
</body>
</html>