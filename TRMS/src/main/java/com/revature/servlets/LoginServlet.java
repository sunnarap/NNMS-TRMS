package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.Credentials;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
		//HTML file names
		private final static String LOGIN_HTML_NAME = "login.html";

		protected void doGet(HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException {
			System.out.println("doGet of LoginServlet");
			request.getRequestDispatcher("login.html").forward(request, response);
		}

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException {
			String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
			Credentials cred = new Credentials(arr);
			System.out.println("doPost of LoginServlet");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			

			boolean successful = true;
			try {
				successful = cred.loginVerification(email, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			String loginButt = request.getParameter("login");
			if(loginButt != null) 
			{
                if(successful == true) 
                {
                	HttpSession sesh = request.getSession(true);
                	sesh.setAttribute("email", email);
                	
                	/*HttpSession sesh2 = request.getSession(false);
                	String email1 = (String) sesh2.getAttribute("email");*/
                	response.sendRedirect(request.getContextPath() + "/dashboard");
                } 
                else 
                {
                	response.setContentType("text/html");
                	PrintWriter pw = response.getWriter();
                	pw.write("<script type=\"text/javascript\" >" + 
                			"alert('Username or Password is incorrect')" + 
                			"</script>");
                	pw.flush();
                	request.getRequestDispatcher("/login.html").include(request, response);

                }
            }
			
            String signupButt = request.getParameter("signup");
            if(signupButt != null) {
            	response.sendRedirect(request.getContextPath() + "/register");
            }
			
			
		}

}
