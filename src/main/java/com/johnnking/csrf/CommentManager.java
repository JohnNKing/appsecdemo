package com.johnnking.csrf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentManager {

	public final static String DB_DRIVER= "org.hsqldb.jdbcDriver";
	public final static String DB_CONN = "jdbc:hsqldb:mem:csrf-jee-example-db";
	public final static String DB_USER = "SA";
	public final static String DB_PASS = "";
	
	/*
	 * Create the Comments table
	 */
	public static void init() throws SQLException, ClassNotFoundException {
		
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS comments (comment varchar(255), username varchar(255))");						
			
			try {
				stmt.execute();
				
				if (CommentManager.getComments().size() == 0) {
					CommentManager.addComment(new Comment("Hello!", "John"));
				}
			    
			} catch (SQLException e ) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e ) {
			throw e;
			
		} finally {
		    conn.close();
		}
	}
	
	/*
	 * Get a list of all comments
	 */
	public static List<Comment> getComments() throws SQLException, ClassNotFoundException {
		List<Comment> result = new ArrayList<Comment>();
		
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("select * from comments");
			
			try {
				ResultSet rs = stmt.executeQuery();
			
				try {
				    while (rs.next()) {
				    	result.add(new Comment(rs.getString("comment"), rs.getString("username")));
			    	}
				    
				} catch (SQLException e ) {
					throw e;
					
				} finally {
					rs.close();
				} 
			    
			} catch (SQLException e ) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e ) {
			throw e;
			
		} finally {
		    conn.close();
		}
			
		return result;
	}
	
	/*
	 * Add a comment
	 */
	public static void addComment(Comment comment) throws SQLException, ClassNotFoundException {
			
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);

		try {
			Statement stmt = conn.createStatement();
			//PreparedStatement stmt = conn.prepareStatement("INSERT INTO comments VALUES ?");
			
			try {
				ResultSet rs = stmt.executeQuery("INSERT INTO comments VALUES ('" + comment.getComment() + "', '" + comment.getUsername() + "');");
				//stmt.setString(1, comment.getComment());
				//stmt.execute();
			    
			} catch (SQLException e ) {
				throw e;
				
			} finally {
				stmt.close();
			}
			
		} catch (SQLException e ) {
			throw e;
			
		} finally {
		    conn.close();
		}
	}
}
