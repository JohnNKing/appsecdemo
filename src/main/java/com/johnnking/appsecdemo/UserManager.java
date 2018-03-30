package com.johnnking.appsecdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

	public final static String DB_DRIVER= "org.hsqldb.jdbcDriver";
	public final static String DB_CONN = "jdbc:hsqldb:mem:appsecdemo";
	public final static String DB_USER = "SA";
	public final static String DB_PASS = "";
	
	/*
	 * Create the User table
	 */
	public static void init() throws SQLException, ClassNotFoundException {
		
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			Statement stmt = conn.createStatement();						
			
			try {
				stmt.execute("CREATE TABLE IF NOT EXISTS users (name varchar(255), password varchar(255))");
				
				if (UserManager.getUsers().size() == 0) {
					UserManager.addUser(new User("Admin"));
					UserManager.addUser(new User("John", "password"));
					UserManager.addUser(new User("Mary Beth", "YT+mrceeJM8od83t"));
					UserManager.addUser(new User("Sam"));
					UserManager.addUser(new User("Dave"));
					UserManager.addUser(new User("Bob"));
				}
			    
			} catch (SQLException e) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
		    conn.close();
		}
	}
	
	/*
	 * Get a list of all users
	 */
	public static List<User> getUsers() throws SQLException, ClassNotFoundException {
		List<User> result = new ArrayList<User>();
		
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			Statement stmt = conn.createStatement();
			
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY name");
			
				try {
				    while (rs.next()) {
				    	result.add(new User(rs.getString("name")));
			    	}
				    
				} catch (SQLException e) {
					throw e;
					
				} finally {
					rs.close();
				} 
			    
			} catch (SQLException e) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
		    conn.close();
		}
			
		return result;
	}
	
	
	/*
	 * Get a particular user
	 */
	public static User getUser(String name) throws SQLException, ClassNotFoundException {
		User result = null;
		
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			Statement stmt = conn.createStatement();
			
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = '" + name + "'");
			
				try {
					if (rs.next()) {
				    	result = new User(rs.getString("name"), rs.getString("password"));
					}
				    
				} catch (SQLException e) {
					throw e;
					
				} finally {
					rs.close();
				} 
			    
			} catch (SQLException e) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
		    conn.close();
		}
			
		return result;
	}	

	/*
	 * Add a user
	 */
	public static void addUser(User user) throws SQLException, ClassNotFoundException {
			
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			Statement stmt = conn.createStatement();
			
			try {
				stmt.execute("INSERT INTO users VALUES ('" + user.getName() + "', '" + user.getPassword() + "')");
			    
			} catch (SQLException e) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
		    conn.close();
		}
	}
}
