<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link rel="stylesheet" type="text/css" href="css/signin.css">
</head>
<body>
 <div class="container" id="container">
	<div class="form-container sign-up-container" style="background-image: url('img/lalala.jpg');">
		
	</div>
	 
	 <div class="overlay-container">
		<div class="overlay">
		<form action="SignInController" method="post">	
			<div class="overlay-panel overlay-left" >
			
			<h1>Sign In</h1>
			<div class="social-container">
				
			</div>
			
			<input type="email" id="email" name="email" placeholder="Email" />
			<input type="password" id="password" name="password" placeholder="Password" />
			<a href="registerr.jsp">No Account? Register Now</a>
			<!--  <input type="submit" class="buttons" value="SIGN IN">-->
			<button>Sign In</button>
			
			</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>