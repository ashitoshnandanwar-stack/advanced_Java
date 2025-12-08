<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*, com.cdac.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Student</title>
</head>
<body>
	<h1>All Registered Student</h1>
	<table border="4" cellpadding="5px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Course</th>
		</tr>
		
	<%
		List<Student> list = (List<Student>) request.getAttribute("studentlist");
		for(Student s : list)
		{
	%>
		<tr>
			<td><%= s.getId() %></td>
			<td><%= s.getName() %></td>
			<td><%= s.getEmail() %></td>
			<td><%= s.getCourse() %></td>
		</tr>
	<%
		}
	%>
	</table>
	<br>
	
	<a href="register.html">Register another student</a>
	

</body>
</html>