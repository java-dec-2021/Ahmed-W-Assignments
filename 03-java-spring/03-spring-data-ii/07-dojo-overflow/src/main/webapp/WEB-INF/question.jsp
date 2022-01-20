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
	<title>New Question</title>
</head>
<body>
	<div class="container">
		<h1>What is your question?</h1>
		<form:form method="POST" action="processquestion" modelAttribute="question">
			<div class="form-group row">
				<form:label path="questionText">Question:</form:label>
				<form:errors path="questionText" />
				<form:textarea path="questionText"/>			
			</div>
			<div class="form-group row">
				<form:label path="temptags">Tags:</form:label>
				<form:errors path="temptags" />
				<form:input path="temptags"/>
			</div>
			<button class="my-3 btn btn-success">Submit</button>
		</form:form>
		
	</div>
</body>
</html>