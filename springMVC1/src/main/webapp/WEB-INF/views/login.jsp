<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML-5>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<!-- to prevent access before login and to prevent going back after logout-->
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	
	<div class="container m-4 mx-auto">
		
		<div class="row border-primary"
			style="background-color: rgb(203, 237, 241)">
			<h3>Login</h3>
		</div>
		
		
		<div class="row border-primary"
			style="background-color: rgb(236, 251, 253)">
			<form action="login" method="post" class="mt-4 col-lg-12">

				<div class="form-group row m-2">
					<label for="uname" class="col-sm-2 col-form-label">Username:</label>
					<div class="col-sm-10">
						<input type="text"  name= "inputUsername"
							placeholder="Nagarro">
					</div>
				</div>

				<div class="form-group row m-2">
					<label for="pass" class="col-sm-2 col-form-label">Password:</label>
					<div class="col-sm-10">
						<input type="password"  name="inputPassword"
							placeholder="Password">
					</div>
				</div>
				
				<div class="row mt-4"
					style="background-color: rgb(203, 237, 241)">
					<div class="col-lg-12" >
						<input type="submit" class="btn btn-outline-success"
										value="Login >>">
					</div>
				</div>
			</form>
		</div>
</div>
</body>

</html>


