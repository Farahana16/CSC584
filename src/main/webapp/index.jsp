<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("currentSessionUser")==null)
      response.sendRedirect("/Camp Booking/signIn.jsp");
  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<%	String email = (String)session.getAttribute("currentSessionUser");%>
		Welcome <%= email %>
		
	  <ul>
	  	<li><a href="loginLogoutController">Logout</a></li>
	  </ul>
	</body>
</html>