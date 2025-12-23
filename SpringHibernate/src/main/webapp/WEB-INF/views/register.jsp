<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form action="register" method="post">
		Project Name : <input type="text" name="name"><br><br>
		Technology : <input type="text" name="technology"><br><br>
		Duration : <input type="number" name="duration"><br><br>
		
		<input type="submit" value="Register">
	</form>
	<br>
	<a href="viewProject">View All Project</a>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</body>
</html>