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
		Password reset failed
	</div>
<% } %>

<form action="ForgotPassword" method="POST" class="form">
    <div class="form-group">
            <label class="sr-only" for="username">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username">
    </div>
	<div class="form-group">
		<label class="sr-only" for="color">What's your favorite color?</label>
		<input type="text" id="color" name="color" class="form-control" placeholder="What's your favorite color?">
	</div>
	
	<button type="submit" class="btn btn-default">Reset Password</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>