<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page isErrorPage="true"%>

<t:partial>
	<div class="container">
		<div class="row">
			<div class="col">
				<h2>
					<c:out value="${event.name}" />
				</h2>

				<p>Host: ${event.host.firstName} ${event.host.lastName}</p>
				<p>
					Date:
					<fmt:formatDate type="date" value="${event.eventDate}" />
				</p>
				<p>Location: ${event.city}, ${event.state}</p>
				<p>People attending event: ${event.attendees.size()}</p>

				<table class="table table-striped">
					<thead class="table-dark">
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.attendees}" var="guest">
							<tr>
								<td>${guest.firstName} ${guest.lastName}</td>
								<td>${guest.city}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="col">

				<table class="table table-striped">
					<tbody>
						<c:forEach items="${messages}" var="message">
							<tr>
								<td>${message.user.firstName} says: ${message.messageText}</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>

				<form:form method="POST" action="/process/message"
					modelAttribute="message">
					<h3>Add comment</h3>
					<div class="form-group row mb-2">
						<form:label path="messageText" class="form-label">Add Comment:</form:label>
						<form:textarea path="messageText" class="form-control" />
						<form:errors path="messageText" class="text-danger" />
					</div>
					<form:hidden path="user" value="${userId}" />
					<form:hidden path="event" value="${event.id}" />
					<button class="btn btn-primary mt-2">Submit Comment</button>
				</form:form>

			</div>
		</div>
	</div>


</t:partial>