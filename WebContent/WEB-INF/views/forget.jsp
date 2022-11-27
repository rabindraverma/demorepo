<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forget_password</title>
</head>
<link rel="stylesheet" type="text/css" href="css/forms.css">
<body>
<h2>Enter your EmailId to forget your Password...</h2>
<form action="forget" method="post">

Email<input type="text" name="email">
<input type="submit" value="Forget">

</form>

<%	
       if(request.getAttribute("errorMsg")!=null){
	   out.println(request.getAttribute("errorMsg"));
       }
     %>
</body>
</html>