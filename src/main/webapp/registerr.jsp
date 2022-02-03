<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
 <div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="#">
			
			<div class="social-container">
			
			</div>
			
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="registerController" method="post">
			<h1>Register Now</h1><br>
			<input type="text" id="name" name="name" placeholder="Name" required/>
			<input type="text" id="username" name="username" placeholder="Username" required/>			
			<input type="tel" id="phoneNum" name="phoneNum" placeholder="Phone Number" pattern="[0-9]{10}" required/>
			<input type="email" id="email" name="email" placeholder="Email" required/>
			<input type="password" id="password" name="password" placeholder="Password" required/>
			<a href="signIn.jsp">Already has account? Sign In Now</a>
			<input type="submit" class="button" value="REGISTER">
		</form>
	</div>
	 <div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				
			</div>
			<div class="overlay-panel overlay-right" style="background-image: url('img/lalala.jpg');">
				<!-- for picture on the right -->
			</div>
		</div>
	</div>
</div>
</body>
</html>