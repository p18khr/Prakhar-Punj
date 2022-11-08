<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel = "stylesheet" href="css/LoginStyle.css">
</head>
<body>
<form action="Login" method="POST">
        <div class = "header" >
        <h3>Login</h3><br>
        </div>
        <div class = "form">
        Username:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <span style="color:red">*</span>&ensp;<input type="text" name="uname" size = "50"> <br><br><br>
        Password:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp; <span style="color:red">*</span>&ensp;<input type="text" name="pass" size = "50"> <br><br><br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;<a href="hell.html">Forgotten your password? </a>
        </div>
        <div class = "button">
    <input type="submit"
            value="Login >>">
</div>
        
    </form>
</body>
</html>