<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>${error}</h3>
	<form method="POST" action="/guess">
    <label>What is the code: <input type="text" name="guess"></label>
     <button>Try Code</button>
	</form>
</body>
</html>