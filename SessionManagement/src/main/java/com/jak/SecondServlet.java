package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jak.models.User;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(true);
		if(session!=null) {
			User user =(User)session.getAttribute("userDetails");
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setEmail(request.getParameter("email"));
			//Re-Write userDetail into session with same session variable name 
			response.sendRedirect("three.html");
			//writer.println(user);
		}
		else {
			writer.println("There is no existing sessions.");
		}
		
		
	}

}
