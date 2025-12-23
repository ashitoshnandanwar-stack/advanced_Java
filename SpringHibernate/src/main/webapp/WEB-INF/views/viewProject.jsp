<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registered Students</h2>

	<table border="1" cellpadding="6px" >
		<tr>
			<th>ID</th>
			<th>Project Name</th>
			<th>Technology</th>
			<th>Duration</th>
		</tr>

		<c:forEach var="s" items="${projects }">
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.technology}</td>
				<td>${s.duration}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="register">Add New Student</a><br><br>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>

</body>
</html>