<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
					
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">ID</th>
								<th class="column2">Name</th>
								<th class="column3">Email</th>
								<th class="column4">User name</th>
								<th class="column5">Password</th>
								<th class="column6">PhoneNum</th>
								<th class="column6">#</th>
							</tr>
						</thead>
						<c:forEach items="${profiles}" var="p" varStatus="profiles">
						<tbody>
								<tr>
									<td class="column1"><c:out value="${p.custid}"/></td>
									<td class="column2"><c:out value="${p.custname}"/></td>
									<td class="column3"><c:out value="${p.custemail}"/></td>
									<td class="column4"><c:out value="${p.custusername}"/></td>
									<td class="column5"><c:out value="${p.custpwd}"/></td>
									<td class="column6"><c:out value="${p.custphonenum}"/></td>
									<td class="column6">
										<a href="ViewProfileController?custid=<c:out value="${p.custid}"/>">View</a><br>
										<a href="UpdateProfileController?custid=<c:out value="${p.custid}"/>">Update</a><br>
										<button  id="<c:out value="${p.custid}"/>" onclick="confirmation(this.id)">Delete</button>
									</td>
								</tr>
						</tbody>
						</c:forEach>
					</table>
					<script>
						function confirmation(int custid){
							console.log(custid);
							var r = confirm("Are you sure want to delete?");
							if(r == true){
								location.href = 'DeleteProfileController?custid=' + custid;
								alert("Profile successfully deleted");
							} else{
								return false;
							}
						}
						</script>
</body>
</html>