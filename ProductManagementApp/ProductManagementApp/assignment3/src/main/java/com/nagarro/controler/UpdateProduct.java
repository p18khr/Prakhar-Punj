package com.nagarro.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nagarro.dao.UpdateProductDao;
import com.nagarro.model.Product;

@MultipartConfig
public class UpdateProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("IN update method get");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("IN update method get");
		Product productObj = new Product();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id"));
		String id = (String) session.getAttribute("id");
		session.removeAttribute("id");
		productObj.setId(Integer.parseInt(id));
		productObj.setTitle(request.getParameter("title"));
		productObj.setSize(request.getParameter("size"));
		productObj.setQuantity(request.getParameter("size"));
		Part part = request.getPart("image");
		UpdateProductDao updateObj = new UpdateProductDao();
		updateObj.updateProduct(part, productObj);
		response.sendRedirect("products.jsp");
	}

}
