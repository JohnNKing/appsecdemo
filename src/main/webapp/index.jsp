<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, org.apache.commons.lang3.StringEscapeUtils, com.johnnking.appsecdemo.CommentManager, com.johnnking.appsecdemo.Comment, com.johnnking.appsecdemo.UserManager, com.johnnking.appsecdemo.User"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<%
	List<Comment> comments = CommentManager.getComments();
	List<User> users = UserManager.getUsers();
%>

<div class="row">
<div class="col-xs-12 col-sm-9">

<h2>Comments</h2>
<ul class="list-group">
	<% for (Comment comment : comments) { %>
		<li class="list-group-item<% if ((comment.getUsername() != null) && (! comment.getUsername().equals(""))) { %> active<% } %>">
			<%= comment.getComment() %>
			
			<% if ((comment.getUsername() != null) && (! comment.getUsername().equals(""))) { %>
				<span class="label">
					<%= comment.getUsername() %>
				</span>
			</li>
			<% } %>
		</li>
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
		<li class="list-group-item"><%= user.getName() %></li>
	<% } %>
</ul>

</div>
</div>
<%@include file="/WEB-INF/include/footer.jsp" %>
