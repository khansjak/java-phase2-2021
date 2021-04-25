package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		//writer.println("Getting Login Reuest...");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		RequestDispatcher rd=null;
		if(username.equals("khansjak") && userpass.equals("123")) {
			//writer.println("Login successful");
			rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}else {
			//writer.println("Login failed");
			rd =request.getRequestDispatcher("login.html");
			rd.include(request, response);
			writer.println("<h3 style='color:red;font-weight:bold;'>Invalid credentials . Please try again !</h3>");
		}
		
	}

}
