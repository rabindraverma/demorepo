<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menuStyle.css">
<link rel="stylesheet" type="text/css" href="css/forms.css">
<meta charset="ISO-8859-1">
<title>registration</title>
</head>
<body>
<h2 style="background-color:powderblue">Registration</h2>
<form action="reg" method="post">
<pre>

	Name   :<input type="text" name="name" required="required" autofocus="autofocus" placeholder="Enter your name..."/>
	
	City   :<input type="text" name="city" required placeholder="Enter your city..."/>
	
	Email  :<input type="text" name="email" required placeholder="Enter your Email..."/>
	
	Mobile :<input type="text" name="mobile" required placeholder="Enter your Mobile..."/>
	
	<input type="submit" value="Save"/>
	</pre>
</form>
<p style="color:red;">
<%	

if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
	
}
%>
</p>
</body>
</html>