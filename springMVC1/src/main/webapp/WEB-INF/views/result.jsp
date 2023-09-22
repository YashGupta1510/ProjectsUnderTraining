<%@page import="java.util.ArrayList"%>
<%@page import="com.nagarro.springMVC1.model.Tshirt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">




</head>

<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	if (session.getAttribute("username") == null)
		response.sendRedirect("login.jsp");
	%>
	<div id="title" style="text-align: right;">
		<form action="Logout" method="post">
			Hi ${username} <input type="submit" value="Logout">
		</form>
	</div>

	<div class="container-fluid">
		<div class="fixed-header">


			<div id="title" style="text-align: center;">
				<h1 style="background-color: DodgerBlue;">Result</h1>
			</div>
			<b>Please Enter tee Details To Enter To Stock</b>
		</div>



		<!-- table creation -->
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Title</th>
					<th scope="col">Size</th>
					<th scope="col">Gender</th>
					<th scope="col">Price</th>
					<th scope="col">Rating</th>
				</tr>
			</thead>
			<tbody>

				<!--display data from database -->
				<%
				ArrayList<Tshirt> tshirts = (ArrayList<Tshirt>) session.getAttribute("tshirts");

				int i = 1;

				for (Tshirt tee : tshirts) {
				%>
				<tr>
					<th scope="row"><%=i++%></th>
					<td><%=tee.getName()%></td>
					<td><%=tee.getSize()%></td>
					<td><%=tee.getGender()%></td>
					<td><%=tee.getPrice()%></td>
					<td><%=tee.getRating()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div id="title" style="text-align: right;">

			<form action="home" method="post">
				Wanna Search again? <input type="submit" value="Search">
			</form>
		</div>
</body>
</html>