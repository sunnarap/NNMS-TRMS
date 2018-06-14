package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.service.Credentials;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("In doGet of LoginServlet");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
		Credentials cred = new Credentials(arr);
		
		System.out.println("In doPost of LoginServlet");
		UserDAOImpl udi = new UserDAOImpl(arr);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = udi.retrieveUser(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user.getPassword() == password) {
			request.getRequestDispatcher("/home").forward(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.print("You shall not pass!");
			request.getRequestDispatcher("/dashboard").forward(request, response);
			pw.close();
		}
		
	}

}
