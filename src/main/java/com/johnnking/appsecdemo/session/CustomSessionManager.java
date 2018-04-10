package com.johnnking.appsecdemo.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnnking.appsecdemo.DB;

public class CustomSessionManager {

    public static void init() throws SQLException, ClassNotFoundException {

        Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS sessions (id VARCHAR(255), username VARCHAR(255))");						
			
			try {
				stmt.execute();

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

    public static CustomSession getSession(String sessionId) throws SQLException, ClassNotFoundException {

        CustomSession result = null;
		
		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM sessions where id = ?");
			stmt.setString(1, sessionId);

			try {
				ResultSet rs = stmt.executeQuery();
	
				try {
				    if (rs.next()) {
				    	result = new CustomSession(rs.getString("id"), rs.getString("username"));
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

    public static void addSession(CustomSession session) throws SQLException, ClassNotFoundException {

		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO sessions (id, username) VALUES (?, ?);");
			stmt.setString(1, session.getId());
			stmt.setString(2, session.getUsername());

			try {
				stmt.execute();
			    
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

	public static void updateSession(CustomSession session) throws SQLException, ClassNotFoundException {

		Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE sessions SET username = ? WHERE id = ?;");
			stmt.setString(1, session.getUsername());
			stmt.setString(2, session.getId());

			try {
				stmt.execute();
			    
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

    public static void deleteSession(String sessionId) throws SQLException, ClassNotFoundException {

        Class.forName(DB.DRIVER);
		Connection conn = DriverManager.getConnection(DB.CONN, DB.USER, DB.PASS);

		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM sessions WHERE id = ?");
			stmt.setString(1, sessionId);
			
			try {
				stmt.execute();
			    
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