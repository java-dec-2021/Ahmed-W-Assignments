<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/result" method="POST">
	<p>Name: <input type="text" name="name"></p>
	<p>Dojo Location: 
	<select name="location">
		<option value="San Jose">San Jose</option>
		<option value="Burbank">Burbank</option>
		<option value="Austin">Austin</option>
	</select></p>
	<p>Favorite Language: 
	<select name="language">
		<option value="Python">Python</option>
		<option value="Java">Java</option>
		<option value="HTML">HTML</option>
	</select></p>
	<p><label for="comment">Comment:</label><textarea name="comment" cols="30" rows="10"></textarea></p>
	<button>Submit</button>
	</form>
</body>
</html>