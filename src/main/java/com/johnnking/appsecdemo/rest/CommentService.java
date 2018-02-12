package com.johnnking.appsecdemo.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import com.johnnking.appsecdemo.Comment;
import com.johnnking.appsecdemo.CommentManager;


@Path("/comment")
public class CommentService {

	@GET
    @Produces({MediaType.APPLICATION_JSON})
	public Response getComment() {
		Response result;
        Gson gson = new Gson();

        try {
            String json = gson.toJson(CommentManager.getComments());
            result = Response.status(200).entity(json).build();

        } catch (Exception e) {
			e.printStackTrace();
            result = Response.status(500).build();
        }

        return result;
	}

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addComment(@Context HttpServletRequest request, @FormParam("comment") String comment, @FormParam("username") String username) {
		Response result;
        HttpSession session = request.getSession(true);

        if ((comment != null) && (! comment.equals(""))) {

            if (username == null) {
                username = (String) session.getAttribute("username");
            }

			try {	
				CommentManager.addComment(new Comment(comment, username));
                result = Response.status(200).build();

			} catch (Exception e) {
				e.printStackTrace();
                result = Response.status(500).build();
			}

		} else {
            result = Response.status(400).build();
        }

        return result;
	}
}