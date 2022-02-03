<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.sql.*" %>
<%@page import="java.util.*"%>
<%@page import="booking.db.ConnectionManager"%>
<%@page import="booking.model.Customer"%>
<!DOCTYPE html>
<html>
	<body>
		<%
			String custemail = request.getParameter("custemail");
			String custpwd = request.getParameter("custpwd");
			try{ 
				//load the driver class  
				Class.forName("com.mysql.jdbc.Driver"); 
				
				//create the connection object 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/campingbooking", "root",""); 

				//create the statement object 
				Statement stmt=con.createStatement(); 
				String sql = "select * from customer where custEmail= '" + custemail + "' and custPwd= '" + custpwd + "'";
				
				//execute query 
				ResultSet rs=stmt.executeQuery(sql); 
				//processing resultset - iterate
				if(rs.next()){
					String custid = rs.getString("custid");
					session.setAttribute("SES_ID",custid);
					response.sendRedirect("homepage.jsp");
				}
				else {
					request.setAttribute("error", "Wrong username or password. Try Again");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); 
					rd.include(request, response);
				} 
				con.close(); 
			}
			catch(Exception e){ 
				System.out.println(e); 
			} 
		%>
	</body>
</html>