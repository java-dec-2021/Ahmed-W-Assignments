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
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${question.questionText}"/></h1>
		
		<div class="row">
		<h3 class="my-3">Tags:</h3>
		<span><c:forEach items="${question.tags}" var="tag">
				
					<button>${tag.subject}</button>
				
			</c:forEach></span>		
		</div>
		
		<div class="row mt-3">
			<div class="col mx-3">
				<table class="table table-striped">
				<thead>
					<tr>
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					
						<c:forEach items="${question.answers}" var="ans">
						<tr>
						<td>${ans.response}</td>
						</tr>
						</c:forEach>	
					
					
				</tbody>			
				</table>
			
			</div>
		
		
		
		<div class="col mx-3">
		
		<h3>Add your Answer</h3>
		<form:form method="POST" action="/processanswer" modelAttribute="answer">
			<div class="form-group row">
				<form:label path="response">Answer:</form:label>
				<form:errors path="response" />
				<form:textarea path="response"/>	
				<form:hidden path="question" value="${question.id}"/>		
			</div>
		<button class="btn btn-warning  my-2">Answer it!</button>
		</form:form>
		<hr></hr>
		<a href="/">Dashboard</a>
		</div>
		
		
		</div>
		
	</div>
</body>
</html>