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


public class ForgotPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String color = request.getParameter("color");
		
		if ((username != null) && (! username.equals(""))
				&& (color != null) && (! color.equals(""))) {
			
			try {
				User user = UserManager.getUser(username);
				if (user != null) {
					if (user.getFavoriteColor().equalsIgnoreCase(color)) {

						// Reset the password to the default
						UserManager.resetPassword(user);

						// For convenience, sign the user in
						SessionController.login(username, request, response);

						// Direct the user to the change password form
						response.sendRedirect(request.getContextPath() + "/change-password.jsp");
						return;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("forgot-password.jsp?error");
	}
}
