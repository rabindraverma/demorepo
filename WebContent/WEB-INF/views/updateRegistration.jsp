<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menuStyle.css">
<link rel="stylesheet" type="text/css" href="css/forms.css">
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
	<h2 style="background-color:skyblue">Update mobile number here...</h2>
	<form action="update" method="post">
	Email  :<input type="text" name="email" value="<%=request.getAttribute("email")%>" readonly>
	<br>
	Mobile :<input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>" required="required">
	<br>
	<input type="submit" value="Update">
	
	</form>
</body>
</html>