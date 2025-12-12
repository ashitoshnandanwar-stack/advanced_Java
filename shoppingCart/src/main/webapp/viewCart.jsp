<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
</head>
<body>

<h1>Your Cart</h1>

<%
	List<String> cart = (List<String>) request.getAttribute("cartItems");

	if (cart == null || cart.isEmpty()) {
%>

	<p>Cart is empty</p>

<%
	} else {
%>

<table border="3" cellpadding="10">
	<tr>
		<th>Sr. No</th>
		<th>Product Name</th>
	</tr>

	<%
		int index = 1;
		for (String item : cart) {
	%>
	<tr>
		<td><%= index %></td>
		<td><%= item %></td>
	</tr>
	<%
			index++;
		}
	%>
</table>

<%
	}
%>

<br><br>
<a href="shopping.html"><button>Back to Products</button></a><br><br>
<a href="logout"><button>Logout</button></a>


</body>
</html>
