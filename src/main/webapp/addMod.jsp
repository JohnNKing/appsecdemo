<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%
if (session.getAttribute("username") == null) {
	// A10 Unvalidated Redirects and Forwards
	response.sendRedirect("login.jsp?destination=%2Fappsecdemo%2FaddMod.jsp");
	//response.sendRedirect("login.jsp?destination=addMod");
}
%>
<%@include file="/WEB-INF/include/header.jsp" %>

<h2>Add Moderator</h2>

<form id="form" action="AddUser" method="POST" class="form-inline">
	<div class="form-group">
		<label class="sr-only" for="username">Username</label>
		<input type="text" id="username" name="name" class="form-control" placeholder="Username">
	</div>
	<button type="submit" class="btn btn-default">Add</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>