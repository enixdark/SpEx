<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>new Task</title>
</head>
<body>
	<form:form action="new" method="post" commandName="task">
		<spring:bind path="name">
			<div class="form-group${status.error ? ' has-eror' : '' }">
				<label for="txtTaskName">Task Name</label>
				<form:input path="name" class="form-control" id="txtTaskName" placeholder="Task Name"/>
				<form:errors path="name" cssClass="control-label"></form:errors>
			</div>
		</spring:bind>
		
		<spring:bind path="priority">
			<div class="form-group${status.error ? ' has-error' : '' }">
				<label for="tpriority">Priority</label>
				<form:select path="priority" id="tpriority" class="form-control">
					<form:option value="-1" label="-- Select --"></form:option>
					<c:forEach var="p" items="${priorities}">
						<form:option value="${p}">${p}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="priority" cssClass="control-label" />
			</div>
		</spring:bind>
		
		<div class="form-group">
			<label for="txtComments">Comments</label>
			<form:textarea path="comment" class="form-control" id="txtComments" placeholder="Comments" 
				rows="5" cols="30"/>
		</div>
		
		<spring:bind path="user.id">
			<div class="form-group${status.error ? ' has-error' : '' }">
				<label for="slCrtBy">Created By</label>
				<form:select path="user" id="slCrtBy" class="form-control">
					<form:option value="1" label="-- Select --"></form:option>
					<form:options items="${users}" itemValue="id" itemLabel="name"/>
				</form:select>
				<form:errors path="user.id" cssClass="control-label" />
			</div>
		</spring:bind>
		
		<spring:bind path="assignee.id">
			<div class="form-group${status.error ? ' has-error' : '' }">
				<label for="aslCrtBy">Created By</label>
				<form:select path="assignee.id" id="aslCrtBy" class="form-control">
					<form:option value="1" label="-- Select --"></form:option>
					<form:options items="${assignees}" itemValue="id" itemLabel="name"/>
				</form:select>
				<form:errors path="assignee.id" cssClass="control-label" />
			</div>
		</spring:bind>
		<button	type="submit" class="btn btn-success">Save</button>
		<a href='<c:url value="/tasks"/>' class="btn btn-primary">Cancel</a>
	</form:form>
</body>
</html>