package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet for Dashboard.
 * @author Marcus Aderele
 *
 */

public class SuperDasboardServlet extends HttpServlet{
	private static final long serialVersionUID = 6L;
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doGet of SuperDashboard Servlet");
		
		
		HttpSession sesh = request.getSession(false);
		//String email = (String) sesh.getAttribute("email");
    	if(sesh == null) {
    		sesh = request.getSession();
    		PrintWriter pw = response.getWriter();
    		pw.write("<script>alert('You're not logged in');</script>");
    	}
		
    	if(sesh.getAttribute("email") == null) {
    		PrintWriter pw = response.getWriter();
    		pw.write("<script>alert('You're not logged in');</script>");
    		response.sendRedirect(request.getContextPath() + "/login");
    	} else {
    		request.getRequestDispatcher("superdash.html").forward(request, response);
    	}
		
		
	}
	
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doPost of SuperDashboard Servlet");
		
	}
}