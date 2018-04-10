package com.johnnking.appsecdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentManager {
	
	/*
	 * Create the Comments table
	 */
	public static void init() throws SQLException, ClassNotFoundException {
		
		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			Statement stmt = conn.createStatement();						
			
			try {
				stmt.execute("CREATE TABLE IF NOT EXISTS comments (id IDENTITY, comment VARCHAR(65535), username VARCHAR(255))");
			    
				if (CommentManager.getComments().size() == 0) {
					CommentManager.addComment(new Comment("Welcome!", "Admin"));
					CommentManager.addComment(new Comment("Hi all", "John"));
					CommentManager.addComment(new Comment("Hello", "Mary Beth"));
					CommentManager.addComment(new Comment("Hey"));
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
	 * Get a list of all comments
	 */
	public static List<Comment> getComments() throws SQLException, ClassNotFoundException {
		List<Comment> result = new ArrayList<Comment>();
		
		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			Statement stmt = conn.createStatement();
			
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM comments");
			
				try {
				    while (rs.next()) {
				    	result.add(new Comment(rs.getInt("id"), rs.getString("comment"), rs.getString("username")));
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
	 * Add a comment
	 */
	public static void addComment(Comment comment) throws SQLException, ClassNotFoundException {
			
		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			Statement stmt = conn.createStatement();
			
			try {
				stmt.execute("INSERT INTO comments (comment, username) VALUES ('" + comment.getComment() + "', '" + comment.getUsername() + "');");
			    
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

	public static void deleteComment(int commentId) throws SQLException, ClassNotFoundException {
		
		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			Statement stmt = conn.createStatement();
			
			try {
				stmt.execute("DELETE FROM comments WHERE id = '" + commentId + "'");
			    
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
