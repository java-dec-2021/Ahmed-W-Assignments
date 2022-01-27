<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page isErrorPage="true"%>

<t:partial>

	<div class="container">

		<h3>Events Near You</h3>
		<table class="table table-striped">

			<thead class="table-dark">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${inArea}" var="event">

					<tr>
						<td><a href="/event/${event.id}">${event.name}</a></td>
						<td><fmt:formatDate type="date" value="${event.eventDate}" /></td>
						<td>${event.city}</td>
						<td>${event.host.firstName}</td>
						<td> 
						<c:choose>
							<c:when test="${event.attendees.contains(user)}">
								<a href="/process/unlike/${event.id}">Cancel</a> 
							</c:when>
							<c:otherwise>
								<a href="/process/like/${event.id}">Attend</a>
							</c:otherwise>
						</c:choose>
						<c:if test="${event.host.id == userId}">  |  
							<a href="/edit/${event.id}">Edit</a>
						</c:if>
						<c:if test="${event.host.id == userId}">  |    
							<a href="/delete/${event.id}">Delete</a>  
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<h3>Events In Other Areas</h3>
		<table class="table table-striped">

			<thead class="table-dark">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${outOfArea}" var="event">

					<tr>
						<td><a href="/event/${event.id}">${event.name}</a></td>
						<td><fmt:formatDate type="date" value="${event.eventDate}" /></td>
						<td>${event.city}</td>
						<td>${event.host.firstName}</td>
						<td> 
						<c:choose>
							<c:when test="${event.attendees.contains(user)}">
								<a href="/process/unlike/${event.id}">Cancel</a> 
							</c:when>
							<c:otherwise>
								<a href="/process/like/${event.id}">Attend</a>
							</c:otherwise>
						</c:choose>
						<c:if test="${event.host.id == userId}">  |  
							<a href="/edit/${event.id}">Edit</a>  
						</c:if>
						<c:if test="${event.host.id == userId}">  |  
							<a href="/delete/${event.id}">Delete</a>  
						</c:if>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>

		</table>

		<div class="row">
			<div class="col-6">
				<form:form method="POST" action="/process/event"
					modelAttribute="event">
					<h3>Create an Event</h3>
					<div class="form-group row mb-2">
						<form:label path="name" class="col-sm-2 col-form-label">Name:</form:label>
						<div class="col-sm-8">
							<form:input path="name" class="form-control" />
							<form:errors path="name" class="text-danger" />
						</div>
					</div>
					<div class="form-group row mb-2">
						<form:label path="eventDate" class="col-sm-2 col-form-label">Date:</form:label>
						<div class="col-sm-8">
							<form:input path="eventDate" type="date" class="form-control" />
							<form:errors path="eventDate" class="text-danger" />
						</div>
					</div>
					<div class="form-group row mb-2">
						<form:label path="city" class="col-sm-2 col-form-label">City:</form:label>
						<div class="col-sm-8">
							<form:input path="city" class="form-control" />
							<form:errors path="city" class="text-danger" />
						</div>
					</div>
					<div class="form-group row mb-2">
						<form:label path="state" class="col-sm-2 col-form-label">State:</form:label>
						<div class="col-sm-8">
							<form:select path="state" class="form-select">
								<form:option value="CA">CA</form:option>
								<form:option value="NY">NY</form:option>
								<form:option value="AZ">AZ</form:option>
								<form:option value="WA">WA</form:option>
								<form:option value="FL">FL</form:option>
								<form:errors path="state" class="text-danger" />
							</form:select>
						</div>
					</div>

					<form:hidden path="host" value="${user.id}" />
					<button class="btn btn-primary mt-2">Submit Event</button>
				</form:form>
			</div>
		</div>
	</div>


</t:partial>