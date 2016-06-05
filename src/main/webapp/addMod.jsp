<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp?destination=addMod.jsp");
}
%>
<%@include file="/WEB-INF/include/header.jsp" %>

<div class="panel-heading">
	<h2>Add Moderator</h2>
</div>

<form id="form" action="/appsecdemo/AddUser" method="POST" class="navbar-form navbar-left">
	<div class="form-group">
		<input type="text" name="name" class="form-control" placeholder="username">
	</div>
	<button type="submit" class="btn btn-default">Add Moderator</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>