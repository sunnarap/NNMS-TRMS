package com.revature.servlets;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet for Dashboard.
 * @author Marcus Aderele
 *
 */

public class DashboardServlet extends HttpServlet{
	



	
	private static final long serialVersionUID = 3L;
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doGet of Dashboard Servlet");

		request.getRequestDispatcher("dashboard.html").forward(request, response);
		
	}
	
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doPost of Dashboard Servlet");
		
	}
	
	

}
