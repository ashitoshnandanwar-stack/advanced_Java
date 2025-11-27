<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Library Books</h2>
<table>
	<tr>
		<th>Title</th>
		<th>Author</th>
		<th>Genre</th>
		<th>Year</th>
	</tr>
	
	<% 
		List<String[]> books = (List<String[]>) request.getAttribute("bookList");
		for(String[] b : books)
		{ 
	%>
	<tr>
		<td><%= b[0] %></td>
		<td><%= b[1] %></td>
		<td><%= b[2] %></td>
		<td><%= b[3] %></td>
	</tr>
	<% } %>

</table>

</body>
</html>