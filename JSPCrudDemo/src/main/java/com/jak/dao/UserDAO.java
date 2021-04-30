package com.jak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jak.model.User;

public class UserDAO {
	private static final String insertUserSQL="INSERT INTO users (name,email,country) values(?,?,?)";
	private static final String deleteUserSQL="DELETE FROM users where id=?";
	private static final String updateUserSQL="UPDATE users SET name=?,email=?,counyt=? where id =?";
	private static final String getUserSQL="SELECT name,email,country FROM users WHERE id =?";
	private static final String getAllUserSQL="SELECT * FROM users";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Simplilearn?useSSL=false","root","Tangy@2020");
			Statement stmt = conn.createStatement();
		}
		catch(Exception e) {
			System.out.println("Exception Caught"+e.getMessage());
		}
		return conn;	
	}
	
	public void insertUser(User user) throws SQLException{
		Connection conn=getConnection();
		PreparedStatement statement = conn.prepareStatement(insertUserSQL);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());
		int rows =statement.executeUpdate();
		System.out.println(rows+" rows inserted");
		conn.close();
		
	}
	
	public void updateUser(User user) throws SQLException {
		Connection conn=getConnection();
		PreparedStatement statement = conn.prepareStatement(updateUserSQL);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());
		statement.setInt(4, user.getId());
		int rows = statement.executeUpdate();
		System.out.println(rows+" rows updated");
		conn.close();
		
	}
	
	public boolean deleteUser(int id) throws SQLException {
		
		Connection conn=getConnection();
		PreparedStatement statement = conn.prepareStatement(deleteUserSQL);
		statement.setInt(1,id);
		int rows = statement.executeUpdate();
		System.out.println(rows+" rows deleted");
		conn.close();
		return true;
		
		
	}
	
	public User gettUser(int id) throws SQLException {
		User user = new User(); 
		Connection conn=getConnection();
		PreparedStatement statement = conn.prepareStatement(getUserSQL);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			user.setName(rs.getString(1));
			user.setEmail(rs.getString(2));
			user.setCountry(rs.getString(3));
			
			
			
			System.out.println("DAO :Name :"+rs.getString("name"));
			System.out.println("DAO :Email :"+rs.getString("email"));
			System.out.println("DAO :Country :"+rs.getString("country"));
			
		}
		return user;
		
		
	}
	
	public List<User> getAllUser() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn=getConnection();
		PreparedStatement statement = conn.prepareStatement(getAllUserSQL);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setCountry(rs.getString(4));
			userList.add(user);
		}
		return userList;	
	}
}
