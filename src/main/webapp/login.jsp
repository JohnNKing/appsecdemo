<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, com.johnnking.csrf.UserManager, com.johnnking.csrf.User"%>

<%@include file="/WEB-INF/include/header.jsp" %>

<h2>Login</h2>
<form action="Login" method="POST" class="navbar-form navbar-left">
	<div class="form-group">
		<input type="text" name="username" class="form-control" placeholder="username">
	</div>
	<div class="form-group">
		<input type="password" name="password" class="form-control" placeholder="password">
	</div>
	<button type="submit" class="btn btn-default">Log In</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>