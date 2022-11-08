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
	<div id="login-container">
		<form action="Login" method="post">
			<div id="login-form">
				<div id="login-header">
					<label class="col-sm-2 col-form-label">Login</label>
				</div>
				<p>
				<p>
				<div class="form-group row" class="form-body">
					<label for="inputUserName" class="col-sm-2 col-form-label"><span
						id="user">Username:</span></label>
					<div class="col-sm-10">
						<input type="text" id="user-textbox" class="form-control"
							class="myTextBox" name=uname>
					</div>
				</div>
				<br>
				<div class="form-group row" class="form-body">
					<label for="inputPassword" class="col-sm-2 col-form-label"><span
						id="pass">Password:</span></label>
					<div class="col-sm-10">
						<input type="password" id="pass-textbox" class="form-control"
							class="myTextBox" name="pass">
					</div>
				</div>
				<div class="form-group row" class="form-body">
					<label class="col-sm-2 col-form-label"> </label>
					<div class="col-sm-10">
						<a href="login.jsp">forgotten your password?</a>
					</div>
				</div>
				<br>
				<div id="login-button">
					<input type="submit" value="Login>>"> <br>
				</div>
			</div>
		</form>
	</div>
</body>
</html>