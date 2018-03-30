<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@include file="/WEB-INF/include/header.jsp" %>

<h2>Sign In</h2>

<%
String error = request.getParameter("error");
if (error != null) { %>
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Error:</span> 
		Authentication failed
	</div>
<% } %>

<form action="Login" method="POST" class="form-inline">
	<div class="form-group">
		<label class="sr-only" for="username">Username</label>
		<input type="text" id="username" name="username" class="form-control" placeholder="Username">
	</div>
	<div class="form-group">
		<label class="sr-only" for="username">Password</label>
		<input type="password" id="password" name="password" class="form-control" placeholder="Password">
	</div>
	
	<%
	String destination = request.getParameter("destination");
	if (destination != null) { %>
		<input type="hidden" name="destination" value="<%= destination %>">
	<% } %>
	<button type="submit" class="btn btn-default">Sign In</button>
</form>

<div>
	<a href="forgot-password.jsp">Forgot password</a>
</div>

<%@include file="/WEB-INF/include/footer.jsp" %>