<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, org.apache.commons.lang3.StringEscapeUtils, com.johnnking.csrf.CommentManager, com.johnnking.csrf.Comment, com.johnnking.csrf.UserManager, com.johnnking.csrf.User"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<%
	CommentManager.init();
	List<Comment> comments = CommentManager.getComments();

	UserManager.init();
	List<User> users = UserManager.getUsers();
%>

<% if (session.getAttribute("username") != null) { %>
	Hello <%= StringEscapeUtils.escapeHtml4((String) session.getAttribute("username")) %><br><br>
<% } %>

<div class="row">
<div class="col-xs-12 col-sm-9">

<h2>Comments</h2>
<ul class="list-group">
	<% for (Comment comment : comments) { %>
		<li class="list-group-item"><%= comment.getComment() %><% //= StringEscapeUtils.escapeHtml4(comment.getComment()) %></li>
	<% } %>
</ul>

<form id="form" action="http://localhost:8080/csrf-jee-example/AddComment" method="POST" class="navbar-form navbar-left">
	<div class="form-group">
		<input type="text" name="comment" class="form-control" placeholder="your comment">
	</div>
	<button type="submit" class="btn btn-default">Post Comment</button>
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
