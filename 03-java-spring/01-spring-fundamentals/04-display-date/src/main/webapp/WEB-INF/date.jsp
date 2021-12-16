<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style.css" />
	<title>Date</title>
</head>
<body onload="alertDate()">
	<h1 class="date"><c:out value="${date}" /></h1>
	
	<script defer src="js/script.js"></script>
</body>
</html>