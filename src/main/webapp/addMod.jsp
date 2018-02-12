<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.net.URLEncoder, org.apache.commons.lang3.StringEscapeUtils" %>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp?destination=" + URLEncoder.encode(request.getContextPath() + "/addMod.jsp", "UTF-8"));
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