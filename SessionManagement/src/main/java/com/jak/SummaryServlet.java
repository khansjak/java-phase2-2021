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
 * Servlet implementation class SummaryServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
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
			user.setContact(request.getParameter("contact"));
			user.setCity(request.getParameter("city"));
			//Re-Write userDetail into session with same session variable name 
			//response.sendRedirect("three.html");
			writer.println("<br/><br/><h3>Welcome"+user.getFirstName()+" "+user.getLastName()+"</h3>");
			writer.println("<br/><br/>Session ID :"+session.getId());
			writer.println("You visited last here on :"+session.getLastAccessedTime());
			writer.println(user);
		}
		else {
			writer.println("There is no existing sessions.");
		}
	}

}
