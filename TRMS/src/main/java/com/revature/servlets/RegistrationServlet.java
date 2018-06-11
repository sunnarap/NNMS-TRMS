package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for new user registration form.
 * @author Nathaniel Simpson
 *
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//HTML file names
	private final static String REG_HTML_NAME = "registration.html";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("doGet of LoginServlet");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("doPost of LoginServlet");
		//response.sendRedirect("home"); //redirect
		request.getRequestDispatcher("home.html").forward(request, response); //forward
	}

}
