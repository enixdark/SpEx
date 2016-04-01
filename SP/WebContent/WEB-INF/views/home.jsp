<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/views/them.jsp"></jsp:include>
<title>Demo title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Welcome to Demo!</h1>
		<hr />
		<P>There are ${totalOpenTasks}(${totalTasks}) open tasks.</P>
	</div>
</body>
</html>