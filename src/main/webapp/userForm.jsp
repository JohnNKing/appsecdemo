<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
}
%>
<%@include file="/WEB-INF/include/header.jsp" %>

<h2>User Form</h2>
<form id="form" action="http://localhost:8080/csrf-jee-example/AddUser" method="POST" class="navbar-form navbar-left">
	<div class="form-group">
		<input type="text" name="name" class="form-control" placeholder="username">
	</div>
	<button type="submit" class="btn btn-default">Add User</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>