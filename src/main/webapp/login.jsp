<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@include file="/WEB-INF/include/header.jsp" %>

<h2>Sign In</h2>

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
		<% // http://localhost:8080/appsecdemo/login.jsp?destination=%22%3E%3Cscript%3Ealert(1)%3C%2Fscript%3E%3Cb%20%22 %>
		<input type="hidden" name="destination" value="<%= destination %><% //= destination.replaceAll("\"", "&quot;") %>">
	<% } %>
	<button type="submit" class="btn btn-default">Sign In</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>