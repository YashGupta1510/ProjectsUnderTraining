<%@page import="java.util.List"%>
<%@page import="com.nagarro.advanceJava5.model.Author"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>Edit Page</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	<div class="fixed-header">
		<div id="title" style="text-align: right;">

			<form action="Logout" method="post">
				<b>Welcome ${username} <input type="submit"
					class="btn btn-outline-success" value="Logout">
			</form>
		</div>
		<div class="row">
			<div id="title" style="text-align: center;">
				<h1 style="background-color: DodgerBlue;">EDIT BOOK DETAILS</h1>

			</div>
			<div class="main-content col-6">
				<form action="editDetails" method="post">
					<div class="mb-3 row">
						<label for="BookCode" class="col-2 mx-4">Book Code</label> <input
							type="text" class="col-4" id="bookCode"
							value="<%=(String) request.getAttribute("bookCode")%> "
							name="bookCode" readonly>

					</div>
					<div class="mb-3 row">
						<label for="BookName" class="col-2 mx-4">Book Name</label> <input
							type="text" class="col-4" id="bookName"
							value=" <%=(String) request.getAttribute("bookName")%> "
							name="bookName" required>

					</div>
					<div class="mb-3 row">
						<label for="Author" class="col-2 mx-4">Author</label> <select
							class="col-4" name="author" id="author" required>

							<%
							for (Author author : (List<Author>) request.getAttribute("authors")) {
							%>

							<option value="<%=author.getName()%>"><%=author.getName()%></option>

							<%
							}
							%>
						</select>

					</div>
					<div class="mb-3 row">
						<label for="AddedOn" class="col-2 mx-4">Added On</label> <input
							type="text" id="addedOn" class="col-4"
							value=" <%=(String) request.getAttribute("addedOn")%>"
							name="addedOn" readonly>
					</div>
					<div class="col-12 mx-4">
						<button type="submit" class="btn btn-outline-success">SAVE</button>


					</div>
				</form>
				<form action=home>
					<div class="col-12 mx-4">
						<button type="submit" class="btn btn-outline-danger">
							CANCEL</button>
					</div>
				</form>
			</div>

		</div>
</body>
</html>