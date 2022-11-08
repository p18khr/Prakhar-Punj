package com.training.nagarro.advancedJava3.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.nagarro.advancedJava3.dao.LoginValidation;
import com.training.nagarro.advancedJava3.model.User;

@WebServlet(name="Login", urlPatterns= {"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User u = new User();
		u.setUserName(request.getParameter("uname"));
		u.setPassword(request.getParameter("pass"));
		LoginValidation daoObj = new LoginValidation();
		if (daoObj.checkUser(u) == true) {
			HttpSession session = request.getSession();
			response.getWriter().print("Login successful");
			session.setAttribute("username", u.getUserName());
			session.setAttribute("password", u.getPassword());
			response.sendRedirect("products.jsp");
		} else {
			response.getWriter().print("Invalid password");
		}
	}
}
