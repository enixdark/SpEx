<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>List Tasks</title>
</head>
<body>
	<table class="table	table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Task</th>
				<th>Status</th>
				<th>Priority</th>
				<th>Created By</th>
				<th>Assigned To</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty tasks}">
				<c:forEach var="task" items="${tasks}">
					<tr>
						<td><a href='<c:url	value="/tasks/${task.id}"/>'>${task.id}</a>
						</td>
						<td>${task.name}</td>
						<td>${task.status}</td>
						<td>${task.priority}</td>
						<td>${task.user.name}</td>
						<td>${task.assignee.name}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>