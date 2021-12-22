<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<nav class="navbar navbar-light bg-light m-3">
 		  <span class="p-3"><a href="/languages">Dashboard</a></span>
	</nav>
	<div class="container p-3 m-3">
		<h3>Language: <span>${language.name}</span> </h1>
		<h3>Creator:  ${language.creator}</h2>
		<h3>Version Number: ${language.version}</h3>
		<a href="/languages/edit/${language.id}">Edit</a>
		<a href="/delete/${language.id}w">Delete</a>
	</div>
</body>
</html>