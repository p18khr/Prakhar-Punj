package com.nagarro.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nagarro.dao.LoginDao;
import com.nagarro.model.User;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User userObj = new User();
		userObj.setUserName(request.getParameter("uname"));
		userObj.setPassword(request.getParameter("pass"));
		LoginDao daoObj = new LoginDao();
		if (daoObj.checkUser(userObj) == true) {
			HttpSession session = request.getSession();
			response.getWriter().print("Login successful");
			session.setAttribute("username", userObj.getUserName());
			session.setAttribute("password", userObj.getPassword());
			response.sendRedirect("products.jsp");
		} else {
			response.getWriter().print("Invalid password");

		}
	}

}
