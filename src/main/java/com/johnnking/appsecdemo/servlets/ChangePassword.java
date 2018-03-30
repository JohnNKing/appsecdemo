package com.johnnking.appsecdemo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johnnking.appsecdemo.User;
import com.johnnking.appsecdemo.UserManager;

public class ChangePassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if ((username != null) && (! username.equals(""))) {

			if (password.equals(password2)) {
				
				try {
					User user = UserManager.getUser(username);
					if (user != null) {
						user.setPassword(password);
						UserManager.updateUser(user);

						response.sendRedirect(request.getContextPath() + "/");
						return;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		response.sendRedirect("change-password.jsp?error");
	}
}
