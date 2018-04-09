package com.johnnking.appsecdemo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnnking.appsecdemo.Comment;
import com.johnnking.appsecdemo.CommentManager;


public class DeleteComment extends HttpServlet {

	public DeleteComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		try {
            int numericId = Integer.parseInt(id);
            CommentManager.deleteComment(numericId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/");
	}
}
