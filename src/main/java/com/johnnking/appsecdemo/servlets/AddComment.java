package com.johnnking.appsecdemo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johnnking.appsecdemo.Comment;
import com.johnnking.appsecdemo.CommentManager;

public class AddComment extends HttpServlet {

	public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String comment = request.getParameter("comment");

		if ((comment != null) && (! comment.equals(""))) {
				
			try {
				CommentManager.addComment(
						new Comment(comment, (String) request.getAttribute("username")));
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect(request.getContextPath() + "/");
	}
}
