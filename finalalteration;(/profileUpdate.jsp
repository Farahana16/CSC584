<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Profile Update</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/styleView.css">
	</head>

	<body>

		<div class="wrapper" style="background-image: url('images/bg1.jpg');">
			<div class="inner">
				<div class="image-holder">
					<img src="images/formbg.jpg" alt="">
				</div>
				
				<form action="UpdateProfileController" method="post">
					<h3>Update Profile</h3>
					
										
					<div class="form-wrapper">
						<input type="text" placeholder="Name" class="form-control" name="custname" id="custname"  value="<c:out value="${p.custname}"/>">
						<i class="zmdi zmdi-account"></i>
					</div>
					
					<div class="form-wrapper">
						<input type="text" placeholder="Username" class="form-control" name="custusername" id="custusername"  value="<c:out value="${p.custusername}"/>">
						<i class="zmdi zmdi-account"></i>
					</div>
					
					<div class="form-wrapper">
						<input type="text" placeholder="Email" class="form-control" name="custemail" id="custemail"  value="<c:out value="${p.custemail}"/>">
						<i class="zmdi zmdi-email"></i>
					</div>
					
					<div class="form-wrapper">
						<input type="text" placeholder="Phone number" class="form-control" name="custphonenum" id="custphonenum"  value="<c:out value="${p.custphonenum}"/>">
						<i class="zmdi zmdi-phone"></i>
					</div>
										
					<div class="form-wrapper">
						<input type="password" placeholder="Password" class="form-control" name="custpwd" id="custpwd"  value="<c:out value="${p.custpwd}"/>">
						<i class="zmdi zmdi-lock"></i>
						<input type="hidden" name="custid" id="custid" value="<c:out value="${p.custid}"/>">
					</div>
					
					<!--  <button> Update<i class="zmdi zmdi-arrow-right"></i></button>-->
					<button class="item" data-toggle="tooltip" data-placement="top" title="Update">
                      Update</button>
				</form>
				
			</div>
		</div>
		
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>