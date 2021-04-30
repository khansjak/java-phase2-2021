package com.jak.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jak.dao.UserDAO;
import com.jak.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;
       

    public UserServlet() {
        super();
        userDao = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			
			switch(action) {
			case "/newuser" :
				userAdd(request,response);
			case "/userform":
				userForm(request,response);
				break;
			case "/deleteuser":
				deleteUser(request,response);
				break;
			case "/edituser":
				editForm(request,response);
				break;
			case "/updateuser":
				updateUser(request,response);
				
			default :
				userList(request,response);
				break;
			}
				
			
		}catch(Exception ex) {
			System.out.println("Exception Caught :");
			System.out.println(ex.getMessage());
		}
	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("update :"+id);
		String name=request.getParameter("name");
		System.out.println("update :"+name);
		String email=request.getParameter("email");
		System.out.println("update :"+email);
		String country=request.getParameter("country");
		System.out.println("update :"+email);
		User modifiedUser = new User(id,name,email,country);
		System.out.println(modifiedUser);
		userDao.updateUser(modifiedUser);
		response.sendRedirect("list");
		
		
	}


	private void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Servlet :Inside Servlet Method");
		User existingUser =  userDao.gettUser(id);
		System.out.println("Servlet -->"+existingUser.getName());
		request.setAttribute("user", existingUser);
		System.out.println("Servlet :existingUser :"+existingUser);
		RequestDispatcher rd = request.getRequestDispatcher("edit-form.jsp");

		
		rd.forward(request, response);
		
	}


	private void userAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name=request.getParameter("name");
		System.out.println(name);
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		if(name!=null && email!=null && country!=null) {
			User newUser=new User(name,email,country);
			userDao.insertUser(newUser);
			response.sendRedirect("list");
		}

		System.out.println("Dint get you , what was that again ?");
			
		
		
		
	}


	private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Deleting User");
		int id = Integer.parseInt(request.getParameter("id"));
		if(userDao.deleteUser(id))
			response.sendRedirect("list");
		else
			System.out.println("There is some error in deletion");
		
	}


	private void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<User> userList = userDao.getAllUser();
		request.setAttribute("listUser", userList);
		RequestDispatcher rd = request.getRequestDispatcher("user-list.jsp");
		rd.forward(request, response);
	}


	private void userForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Creating a new user...");
		RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
