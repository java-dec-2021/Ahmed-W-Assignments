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
	<title>Main Page</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to the Event App</h1>
		<div class="row ">
			<div class="col p-3 m-3 bg-dark ">
				     
			    <form:form method="POST" action="/registeruser" modelAttribute="user">
			   		<h2 class="my-2 text-light">Register</h2>
			   		<div class="form-group row my-3">
						<form:label path="firstName" class="col-sm-2 col-form-label text-light">First Name:</form:label>
						<div class="col-sm-8">
							<form:input path="firstName" class="form-control"/>
							<form:errors path="firstName" class="text-danger" />
						</div>											
					</div>
					<div class="form-group row my-3">
						<form:label path="lastName" class="col-sm-2 col-form-label text-light">Last Name:</form:label>
						<div class="col-sm-8">
							<form:input path="lastName" class="form-control"/>
							<form:errors path="lastName" class="text-danger"/>
						</div>			
					</div>
					<div class="form-group row my-3">
						<form:label path="email" class="col-sm-2 col-form-label text-light">Email:</form:label>
						<div class="col-sm-8">
							<form:input path="email" class="form-control"/>
							<form:errors path="email" class="text-danger"/>
						</div>			
					</div>
					<div class="form-group row my-3">
						<form:label path="city" class="col-sm-2 col-form-label text-light">City:</form:label>
						
						<div class="col-sm-8">
							<form:input path="city" class="form-control"/>
							<form:errors path="city" class="text-danger"/>
						</div>
					
					</div>
					<div class="form-group row my-3">
						<form:label path="state" class="col-sm-2 col-form-label text-light">State:</form:label>
						
						<div class="col-sm-8">
						<form:select path="state" class="form-select">
							<form:option value="CA">CA</form:option>
							<form:option value="NY">NY</form:option>
							<form:option value="AZ">AZ</form:option>
							<form:option value="WA">WA</form:option>
							<form:option value="FL">FL</form:option>
							<form:errors path="state" class="text-danger"/>
						</form:select>
						</div>
					
					</div>
					<div class="form-group row mb-3">
						<form:label path="password" class="col-sm-2 col-form-label text-light">Password:</form:label>
						
						<div class="col-sm-8">
						<form:password path="password" class="form-control"/>
						<form:errors path="password" class="text-danger"/>		
						</div>	
					</div>
					<div class="form-group row my-3">
						<form:label path="passwordConfirmation" class="col-sm-2 col-form-label text-light">Confirm Password:</form:label>
						<form:errors path="passwordConfirmation" class="text-danger"/>
						<div class="col-sm-8">
						<form:password path="passwordConfirmation" class="form-control"/>			
						
						</div>
					</div>
					<button class="btn btn-primary my-2">Register</button>
			    </form:form>
			    
			</div>
			<div class="col p-3 m-3 bg-light">
				
				<form method="post" action="/login">
			     <h2>Login</h2>
			     <p class="text-danger">${loginError}</p> 
			      <div class="form-group row mt-2">
			          	<label type="email" for="email" class="col-sm-2 col-form-label">Email</label>
			          	<div class="col-sm-10">
			            	<input type="text" id="email" name="email" class="form-control"/>
			            </div>
			      </div>
			      <div class="form-group row mt-2">
			      		<label for="password" class="col-sm-2 col-form-label">Password</label>
			            <div class="col-sm-10">
			            	<input type="password" id="password" name="password" class="form-control"/>
			            </div>
			      </div>
			    		    		            			       
        		<input type="submit" class="btn btn-success mt-2" value="Login!"/>
   				 </form>    
				
			</div>
		</div>
	</div>
	
</body>
</html>