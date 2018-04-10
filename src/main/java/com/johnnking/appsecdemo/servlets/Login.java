package com.johnnking.appsecdemo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnnking.appsecdemo.User;
import com.johnnking.appsecdemo.UserManager;
import com.johnnking.appsecdemo.session.SessionController;

public class Login extends HttpServlet {

	public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ((username != null) && (! username.equals("")) && (password != null)) {
			
			try {
				User user = UserManager.getUser(username);
				if (user != null) {
					if (user.getPassword().equals(password)) {
						SessionController.login(username, request, response);

						String destination = request.getParameter("destination");
						if (destination == null) {
							destination = request.getContextPath() + "/";
						}
						response.sendRedirect(destination);
						
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
