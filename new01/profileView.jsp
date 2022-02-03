<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RegistrationForm_v1 by Colorlib</title>
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
					<img src="images/formbg.jpg" alt="#">
				</div>
				
				<div class="div1">
					<h3>Profile Details</h3>
					<div class="form-wrapper">
						<h4>Name : <c:out value="${p.custname}"/></h4>
						<br><br>
					</div>

					<div class="form-wrapper">
						<h4>Email :  <c:out value="${p.custemail}"/></h4>
						<br><br>
					</div>

					<div class="form-wrapper">
						<h4>User name :  <c:out value="${p.custusername}"/></h4>
						<br><br>
					</div>

					<div class="form-wrapper">
						<h4>Password :  <c:out value="${p.custpwd}"/></h4>
						<br><br>
					</div>
					
					<div class="form-wrapper">
						<h4>Phone number : 0<c:out value="${p.custphonenum}"/></h4>
						<br><br>
					</div>
					
                      <a href="UpdateProfileController?custid=<c:out value="${p.custid}"/>"><button class="item" data-toggle="tooltip" data-placement="top" title="Update">
                      Update</button></a>
                                              
                       <button  id=<c:out value="${p.custid}"/>  onclick="confirmation(this.id)" >Delete</button>
				</div>
			</div>
		</div>
		<script>
		function confirmation(custid){
			console.log(custid);
			var r = confirm("Are you sure want to delete?");
			if(r == true){
				location.href = 'DeleteProfileController?custid='+custid;
				alert("Customer successfully deleted");
			} else{
				return false;
			}
		}
		</script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>