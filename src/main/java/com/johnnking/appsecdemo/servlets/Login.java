package com.johnnking.appsecdemo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnnking.appsecdemo.UserManager;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ((username != null) && (! username.equals("")) && (password != null) && (! password.equals(""))) {
			
			try {
				if (UserManager.getUser(username) != null) {
					if (username.equals(password)) { // Yes, this is intentionally insecure
						request.getSession(true).invalidate();
						request.getSession(true).setAttribute("username", username);
						
						// A10 Unvalidated Redirects and Forwards
						String destination = request.getParameter("destination");
						if (destination == null) {
							destination = request.getContextPath() + "/";
						}
						response.sendRedirect(destination);
						/*
						String destination = request.getContextPath() + "/";
						if ("addMod".equals(request.getParameter("destination"))) {
							destination += "addMod.jsp";
						}
						response.sendRedirect(destination);
						*/
						
						return;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("login.jsp?error");
	}
}
