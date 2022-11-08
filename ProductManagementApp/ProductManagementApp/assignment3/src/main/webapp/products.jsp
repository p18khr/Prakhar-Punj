<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.nagarro.model.User"%>
<%@page import="com.nagarro.dao.GetImageData"%>
<%@page import="com.nagarro.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<link rel="stylesheet" href="css/products.css">
</head>
<body style="padding-left: 2rem">
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Progma", "no-cache");
		response.setHeader("Expires", "0");

		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<header>
		<div class="spc-btw">
			<h1>Product Management Tool</h1>
			<div class="profile">
				<form action="Logout" method="post">
					<label>Welcome ${username}</label> &nbsp; <input type="submit"
						value="Logout">
				</form>
			</div>
		</div>
	</header>
	<div>
		<form method="post" action="ImageMap" enctype="multipart/form-data">
			<h3>Please enter products details to add to stock.</h3>
			<table>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="text" name="quantity"></td>
				</tr>
				<tr>
					<td>Size</td>
					<td><input type="text" name="size"></td>
				</tr>
				<tr>
					<td>Image</td>
					<td><input type="file" name="imgFile" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save"></td>
					<td><input type="reset"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="box3">
		<div>
			<h2 style="margin-top: 40px">Uploaded Images</h2>
			<table style="width: 100%" border="1">
				<tr>
					<th>S.NO</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
				<%
					List<Product> products = new ArrayList<Product>();
					products = GetImageData.getImageDatas();
					int index = 0;
					for (Product product : products) {
						index++;
				%>
				<tr>
					<th><%= index%></th>
					<th><%= product.getTitle()%></th>
					<th><%= product.getQuantity()%> </th>
					<th><%= product.getSize()%> </th>
					<th>
					<%String base64Image=Base64.getEncoder().encodeToString(product.getImage()); %>
                     <img src="data:image/jpg;base64,<%=base64Image%>"/>
					</th>
					<th><form action = "EditProduct?id=<%= product.getId() %>" method ="post"}>
							<button class="button" type="submit" style="margin: 3px">Edit</button>
					</form>
						<form action="DeleteProduct?id=<%= product.getId() %>" method="post">
							<button class="button" type="submit" style="margin: 3px">Remove</button>
						</form>
					</th>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>