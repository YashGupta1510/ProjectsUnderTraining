<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="container m-4 mx-auto">
		<form action="Logout" method="post">
			Hi ${username} <input type="submit" value="Logout">
		</form>
		<div class="row border-primary"
			style="background-color: rgb(236, 251, 253);">
			<form action="search" method="post"
				class="was-validated mt-4 col-lg-12">
				<div class="form-group row m-2">
					<label for="gender" class="col-sm-2 col-form-label">Gender
						: </label>
					<div class="col-sm-10">
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" value="M"
								name="gender" required> <label
								class="custom-control-label" for="customControlValidation2">Male</label>
						</div>
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" value="F"
								name="gender" required> <label
								class="custom-control-label" for="customControlValidation2">Female</label>
						</div>
						<div class="custom-control custom-radio mb-3">
							<input type="radio" class="custom-control-input" value="U"
								name="gender" required> <label
								class="custom-control-label" for="customControlValidation3">Unisex</label>
							<div class="invalid-feedback">*required</div>
						</div>
					</div>
				</div>



				<div class="form-group row m-2">
					<label for="size" class="col-sm-2 col-form-label">Size : </label>
					<div class="col-sm-10">
						<select class="custom-select" name="size" required>
							<option value="">Open this select menu</option>
							<option value="S">S</option>
							<option value="M">M</option>
							<option value="L">L</option>
							<option value="XL">XL</option>
						</select>
					</div>
					<div class="invalid-feedback">*required</div>
				</div>



				<div class="form-group row m-2">
					<label for="colour" class="col-sm-2 col-form-label">Colour
						: </label>
					<div class="col-sm-10">
						<input type="text" name="colour" placeholder="Black" required>
					</div>
					<div class="invalid-feedback">*required</div>
				</div>



				<div class="custom-control custom-checkbox mb-3">
					<label for="pref" class="col-sm-2 col-form-label">Output
						Preference : </label> <input type="checkbox" class="custom-control-input"
						name="preference" value="P"> <label>Order by Price</label>
					<input type="checkbox" class="custom-control-input"
						name="preference" value="R"> <label> Order by
						Rating </label>
					<div class="invalid-feedback">*required</div>
				</div>



				<div class="row m-4">
					<div class="col-lg-12">
						<input type="submit" class="btn btn-primary" value="Submit >>">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
