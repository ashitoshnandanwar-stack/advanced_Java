<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Registration</h1><br>
	<table border="4" cellpadding="5px">
		<tr>
			<th>Name</th>
			<th>PRN</th>
			<th>Age</th>
			<th>Course</th>
		</tr>
		
		<tr>
			<td>${StudList.name }</td>
			<td>${StudList.prn }</td>
			<td>${StudList.age }</td>
			<td>${StudList.course }</td>
		</tr>
		
	</table>
	<a href="register">Add another student </a>
	

</body>
</html>