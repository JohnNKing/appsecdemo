<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, org.apache.commons.lang3.StringEscapeUtils, com.johnnking.appsecdemo.CommentManager, com.johnnking.appsecdemo.Comment, com.johnnking.appsecdemo.UserManager, com.johnnking.appsecdemo.User"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<%
	CommentManager.init();
	List<Comment> comments = CommentManager.getComments();

	UserManager.init();
	List<User> users = UserManager.getUsers();
%>

<div class="row">
<div class="col-xs-12 col-sm-9">

<h2>Comments</h2>
<ul class="list-group">
	<% for (Comment comment : comments) { %>
		<% if (comment.getUsername().equals("null")) { %>
			
			<li class="list-group-item">
				<%= comment.getComment() %>
				<% //= StringEscapeUtils.escapeHtml4(comment.getComment()) %>
			</li>
			
		<% } else { %>
			
			<li class="list-group-item active">
				<%= comment.getComment() %>
				<% //= StringEscapeUtils.escapeHtml4(comment.getComment()) %>
				<span class="label">
					<%= StringEscapeUtils.escapeHtml4(comment.getUsername()) %>
				</span>
			</li>
			
		<% } %>
	<% } %>
</ul>

<form id="form" action="AddComment" method="POST" class="">
	<div class="form-group">
		<textarea name="comment" class="form-control" placeholder="Your comment..."></textarea>
	</div>
	<button type="submit" class="btn btn-default">Post</button>
</form>

</div>
<div class="col-xs-12 col-sm-3">

<h4>Moderators</h4>
<ul class="list-group">
	<% for (User user : users) { %>
		<li class="list-group-item"><%= StringEscapeUtils.escapeHtml4(user.getName()) %></li>
	<% } %>
</ul>

</div>
</div>
<%@include file="/WEB-INF/include/footer.jsp" %>
