<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style.css" />
	<title>Time</title>
</head>
<body onload="alertTime()">
	<h1 class="time"><c:out value="${time}" /></h1>
	
	<script defer src="js/script.js"></script>
</body>
</html>