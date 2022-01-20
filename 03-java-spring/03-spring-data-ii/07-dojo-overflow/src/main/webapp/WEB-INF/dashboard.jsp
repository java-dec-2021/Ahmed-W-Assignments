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
	<title>Questions Dashboard</title>
</head>
<body>
	<div class="container">
	<h1>Questions Dashboard</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questions}" var="q">
			
			<tr>
				<td><a href="/question/${q.id}">${q.questionText}</a>
				</td>
				<td>
					<c:forEach items="${q.tags}" var="tag">
						${tag.subject} 
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/questions">New Question</a>
	</div>
</body>
</html>