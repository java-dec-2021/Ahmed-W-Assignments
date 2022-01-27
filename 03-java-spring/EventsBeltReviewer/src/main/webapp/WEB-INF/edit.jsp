<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page isErrorPage="true"%>

<t:partial>

	<div class="row">
		<div class="col-6">
			<form:form method="POST" action="/update/event/${event.id}" modelAttribute="event">
				<h3>Update an Event</h3>
				<input type="hidden" name="_method" value="put">
				<form:hidden path="host" value="${userId}" />
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
						<form:input path="eventDate" class="form-control" />
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

				
				<button class="btn btn-primary mt-2">Update Event</button>
			</form:form>
		</div>
	</div>

</t:partial>