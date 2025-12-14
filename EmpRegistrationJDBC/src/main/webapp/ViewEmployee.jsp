<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.* , com.cdac.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>View Registration</h1>

<table border="5" cellpadding="8px">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Course</th>
	</tr>
	<%
	List<Employee> list = (List<Employee>) request.getAttribute("viewEmployee");
	for(Employee e : list)
	{
	%>
	<tr>
		<td><%= e.getId() %></td>
		<td><%= e.getName() %></td>
		<td><%= e.getEmail() %></td>
		<td><%= e.getCourse() %></td>
	</tr>
	<%
	}
	%>
	

</table>
<br>
<a href="register.html"><button>Register Another Employee</button></a>
<br><br>
<a href="logout"><button>Logout</button></a>

</body>
</html>