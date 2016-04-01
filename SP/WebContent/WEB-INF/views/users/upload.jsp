<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
</head>
<body>
	<form:form action="../${user.id}/profileForm" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label for="txtUserName">Choose File</label> <input type="file"
				name="profileImage" />
		</div>
		<button type="submit" class="btn btn-success">Upload</button>
		<a href="../${user.id}" class="btn btn-primary">Cancel</a>
	</form:form>
</body>
</html>