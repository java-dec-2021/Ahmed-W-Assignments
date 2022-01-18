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
	<title>${category.name} Page</title>
</head>
<body>
	<div class="container col-4">
		<h1 class="my-3">${category.name}</h1>
		<div>
			<h3 class="my-3">Products:</h3>
			<c:forEach items="${category.products}" var="product">
				<p>- ${product.name}</p>
			</c:forEach>
				
		</div>
		
			
		<form method="POST" action="/category/${category.id}/addproduct">
			<label>Select a product:</label>
			<select name="product">
				<c:forEach items="${product}" var="products">
					<option value="${products.id}">${products.name}</option>
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