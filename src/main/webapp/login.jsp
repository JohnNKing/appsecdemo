<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@include file="/WEB-INF/include/header.jsp" %>

<div class="panel-heading">
	<h2>Login</h2>
</div>

<form action="Login" method="POST" class="navbar-form navbar-left">
	<div class="form-group">
		<input type="text" name="username" class="form-control" placeholder="username">
	</div>
	<div class="form-group">
		<input type="password" name="password" class="form-control" placeholder="password">
	</div>
	<%
	String destination = request.getParameter("destination");
	if (destination != null) { %>
		<input type="hidden" name="destination" value="<%= destination %>">
	<% } %>
	<button type="submit" class="btn btn-default">Log In</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>