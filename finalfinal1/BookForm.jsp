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
				
				<form action="AddBookingController" method="post">
					<h3>Book Room</h3>
					
										
					<div class="form-wrapper">
						<input type="date" class="form-control"  id="checkin" placeholder="Check in date" name="checkin">
						<input type="hidden" class="form-control"  id="custid"  name="custid" value="<c:out value="${c.custid}"/>">
					</div>
					
					<div class="form-wrapper">
						<input type="date"  placeholder="Check out date"  class="form-control"  id="checkout" name="checkout">
					</div>
					
					<div class="form-wrapper">
						<select  name="numOfAdults" id="numOfAdults" class="form-control"  >
                                    <option data-display="Adult">Adult</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
					</div>
					
					<div class="form-wrapper">
						<select name="numOfChild" id="numOfChild" class="form-control">
                                    <option data-display="Children">Children</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
					</div>
					
					<div class="form-wrapper">
						<select name="roomType" id="roomType" class="form-control">
                                    <option data-display="Room type">Room type</option>
                                    <option value="111">The Dome</option>
                                    <option value="121">The Classics</option>
                                    <option value="131">The Traditional</option>
                                    <option value="141">The Family Suite</option>
                                </select>
					</div>
					
					<button type="submit" class="boxed-btn3">Check Availability</button>
				</form>
				
			</div>
		</div>
		
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>