<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/loginStyle.css">
</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Progma", "no-cache");
		response.setHeader("Expires", "0");

		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div id="login-container">
		<form action="UpdateProduct" method="post" enctype="multipart/form-data">
			<div id="login-form">
				<div id="login-header">
					<label class="col-sm-2 col-form-label">Login</label>
				</div>
				<p>
				<p>
				<div class="form-group row" class="form-body">
					<label for="title" class="col-sm-2 col-form-label"><span
						id="user">Title</span></label>
					<div class="col-sm-10">
						<input type="text" id="user-title" class="form-control"
							class="myTextBox" name="title">
					</div>
				</div>
				<div class="form-group row" class="form-body">
					<label for="inputUserName" class="col-sm-2 col-form-label"><span
						id="user">Quantity</span></label>
					<div class="col-sm-10">
						<input type="text" id="user-quantity" class="form-control"
							class="myTextBox" name="quantity">
					</div>
				</div>
				<div class="form-group row" class="form-body">
					<label for="inputUserName" class="col-sm-2 col-form-label"><span
						id="user">Size</span></label>
					<div class="col-sm-10">
						<input type="text" id="user-size" class="form-control"
							class="myTextBox" name="size">
					</div>
				</div>
				<div class="form-group row" class="form-body">
					<label for="inputImage" class="col-sm-2 col-form-label"><span
						id="pass">Image</span></label>
					<div class="col-sm-10">
						<input type="file" id="pass-image" class="form-control"
							class="myTextBox" name="image">
					</div>
				</div>
				<div id="login-button">
					<input type="submit" value="Update"> <br>
				</div>
			</div>
		</form>
	</div>
</body>
</html>