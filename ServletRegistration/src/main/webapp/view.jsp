<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "java.io.*"  %>
 <%@ page import = "com.cdac.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
      Student s = (Student) request.getAttribute("stu");   
%>
<h2>Student Registration details</h2>

    <h3>   <%= s.getName() %></h3>
    <h3>   <%= s.getPrn() %></h3>
    <h3>   <%= s.getEmail() %></h3>
</body>
</html>