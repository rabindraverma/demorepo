<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="css/menuStyle.css">
<link rel="stylesheet" type="text/css" href="css/forms.css">
<meta charset="ISO-8859-1">
<title>search</title>
</head>
<body>


	<h2 style="background-color: powderblue">All Registration</h2>
	<table id="customers">
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>

		</tr>
		<%
			ResultSet result = (ResultSet) request.getAttribute("res");
			while (result.next()) {
		%>
		<tr>
			<td><%=result.getString(1)%></td>
			<td><%=result.getString(2)%></td>
			<td><%=result.getString(3)%></td>
			<td><%=result.getString(4)%></td>
			<td><a href="delete?email=<%=result.getString(3)%>">delete</a></td>
			<td><a
				href="update?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">update</a></td>
		</tr>


		<%
			}
		%>


	</table>

</body>
</html>