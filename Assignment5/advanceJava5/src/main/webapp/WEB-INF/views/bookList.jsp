<%@page import="com.nagarro.advanceJava5.model.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>BookList Screen</title>
</head>
<body>
	<!-- to prevent access before login and to prevent going back after logout-->
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>


	<div class="container-fluid">
		<div class="fixed-header">
			<div id="title" style="text-align: right;">

				<form action="Logout" method="post">
					<b>Welcome ${username} <input type="submit"
						class="btn btn-outline-success " value="Logout">
				</form>
			</div>
			<div id="title" style="text-align: center;">
				<h1 style="background-color: DodgerBlue;">Books Listing</h1>

			</div>

			<form action="Add" method="post">
				<button type="submit" class=" btn mt-5 px-3"
					style="text-align: center; font-size: 25px; font-weight: 500; margin-left: 87%">AddBook</button>
			</form>
			<!-- table creation -->
			<table class="table table-bordered table-hover table-striped">
				<thead class="text-center">
					<tr>
						<th scope="col">Book Code</th>
						<th scope="col">Book Name</th>
						<th scope="col">Author</th>
						<th scope="col">Data Added</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>

					<%
					List<Book> books = (List<Book>) request.getAttribute("books");

					for (Book book : books) {
					%>
					<tr class="text-center">
						<td><%=book.getBookCode()%></td>
						<td><%=book.getBookName()%></td>
						<td><%=book.getAuthor().getName()%></td>
						<td><%=book.getAddedOn()%></td>
						<td class="col-1 text-center">
							<form action="Edit" method="post">
							
									<input type="text" name="bookCode" value="<%=book.getBookCode()%>" hidden> 
									<input type="text" name="bookName" value="<%=book.getBookName()%>" hidden>
									 <input type="text" name="author" value="<%=book.getAuthor().getName()%>" hidden>
									<input type="text" name="addedOn" value="<%=book.getAddedOn()%>" hidden>
									<button type="submit" id="submit-btn"
									class=" col-5 p-2 mx-5 btn btn-primary ">Edit</button>
									
							</form>
							<form action="delete" method="post">
								<input type="text" name="bookCode" value="<%=book.getBookCode()%>"
									hidden>
								<button type="submit" id="submit-btn"
									class="col-5 p-2 mx-5 mt-2 btn btn-danger ">Delete</button>
							</form>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
</body>
</html>