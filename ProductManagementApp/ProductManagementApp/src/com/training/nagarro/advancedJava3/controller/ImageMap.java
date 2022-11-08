package com.training.nagarro.advancedJava3.controller;

import java.io.IOException;

import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.training.nagarro.advancedJava3.dao.ImageDao;
import com.training.nagarro.advancedJava3.model.Product;
import com.training.nagarro.advancedJava3.model.User;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024
		* 1, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ImageMap extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product productObj = new Product();
		User userObj = new User();
		productObj.setTitle(request.getParameter("title"));
		productObj.setSize(request.getParameter("size"));
		productObj.setQuantity(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		System.out.println(username + "username");
		System.out.println(username + "password");
		userObj.setPassword(password);
		userObj.setUserName(username);
		productObj.setUser(userObj);
		System.out.print(request.getParameter("title"));
		System.out.print(request.getParameter("size"));
		Part part = request.getPart("imgFile");
		ImageDao insertObj = new ImageDao();
		insertObj.insertProduct(part, productObj);
		response.sendRedirect("products.jsp");
	}
}
