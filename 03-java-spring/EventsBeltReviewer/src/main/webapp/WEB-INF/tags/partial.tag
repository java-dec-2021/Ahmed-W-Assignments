<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title></title>
</head>
<body>
<div class="container">
	
	<nav class="navbar navbar-expand-lg navbar-light bg-dark mb-3">
  		<div class="container-fluid">
	   		<a class="navbar-brand p-3 text-light">Welcome <c:out value="${userFirstName}"/></a>
	    	
   		 <div class="collapse navbar-collapse" id="navbarText">
		     <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link text-warning" aria-current="page" href="/item/new">Placeholder</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-warning" href="/dashboard">Dashboard</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-warning" href="#">Placeholder</a>
		        </li>
		      </ul>
      		<a class="btn btn-warning" href="/logout">
        		Logout
      		</a>
   		 </div>
  		</div>
	</nav>
	
	
	<jsp:doBody/>
	
	
	<hr>

	
</div>
</body>
</html>