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
	//private final static String REG_HTML_NAME = "registration.html";
	private final static String REG_HTML_NAME = "register.html";
	
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response)
//					throws ServletException, IOException {
//		System.out.println("doGet of LoginServlet");
//		RequestDispatcher rd = request.getRequestDispatcher("login.html");
//		rd.forward(request, response);
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("register.html");
		resp.setContentType("text/html");
		rd.forward(req, resp);
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println(req.getRequestURI());
		System.out.println(req.getParameter("fname"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hi");
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		req.getRequestDispatcher("register.html").forward(req, resp);
	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response)
//					throws ServletException, IOException {
//		System.out.println("doPost of LoginServlet");
//		//response.sendRedirect("home"); //redirect
//		request.getRequestDispatcher("home.html").forward(request, response); //forward
//	}

}
