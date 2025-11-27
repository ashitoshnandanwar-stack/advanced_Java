<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String pageName = request.getParameter("page");
		if(pageName.equals("java")){
			response.sendRedirect("java.jsp");
		}
		else if(pageName.equals("javaScript")){
			response.sendRedirect("javaScript.jsp");
		}
	%>

</body>
</html>