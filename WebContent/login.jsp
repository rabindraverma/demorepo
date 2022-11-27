<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/forms.css">
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
  <h2 style="background-color:skyblue">Login Here</h2>
     <form action="verifyLogin" method="post">
     <pre>

     <label>Email</label>
    <input type="text" id="email" name="email" placeholder="Enter your email..">

    <label>Password</label>
    <input type="password" id="password" name="password" placeholder="Enter your password.."></pre>
   	<input type="submit" value="login">
    <a href="for">Forget password</a>
      
      </form>
  <p style="color:red">
     <%	
       if(request.getAttribute("errorMsg")!=null){
	   out.println(request.getAttribute("errorMsg"));
       }
     %>
     
      <%	
       if(request.getAttribute("sessionMsg")!=null){
	   out.println(request.getAttribute("sessionMsg"));
       }
     %>
  </p>

</body>
</html>