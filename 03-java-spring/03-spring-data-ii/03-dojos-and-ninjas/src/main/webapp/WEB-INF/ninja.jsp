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
	<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<div class="container col-3">
	<form:form method="POST" action="/processninja" modelAttribute="ninja">
		<div class="row g-3 align-items-center">
		<form:label path="dojo" class="col-auto">Dojo:</form:label>
		<form:select path="dojo" class="form-control">
			<c:forEach items="${dojos}" var="dojo">
				<option value="${dojo.id}">
					${dojo.name}
				</option>
			</c:forEach>
		</form:select>
		</div>
		
		<div class="row g-3 align-items-center">
			<form:label path="firstName" class="col-auto">First Name: </form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName" class="form-control"/>
		</div>
		<div class="row g-3 align-items-center">
			<form:label path="lastName">Last Name: </form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName" class="form-control"/>
		</div>
		<div class="row g-3 align-items-center">
			<form:label path="age">Age: </form:label>
			<form:errors path="age"/>
			<form:input path="age" class="form-control"/>
		</div>
		<p>
		<button class="my-3 btn btn-primary">Create</button>
		</p>
	</form:form>
	
	</div>
</body>
</html>