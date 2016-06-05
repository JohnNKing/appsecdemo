package com.johnnking.appsecdemo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnnking.appsecdemo.User;
import com.johnnking.appsecdemo.UserManager;


public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(true).getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
			
		} else {
			String name = request.getParameter("name");
			
			if ((name != null) && (! name.equals(""))) {
				
				try {
					UserManager.addUser(new User(name));
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			response.sendRedirect("/appsecdemo/");
		}
	}
}
