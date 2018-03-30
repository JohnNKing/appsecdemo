<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@include file="/WEB-INF/include/header.jsp" %>

<h2>Change Password</h2>

<%
String error = request.getParameter("error");
if (error != null) { %>
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Error:</span> 
		Password change failed
	</div>
<% } %>

<form action="ChangePassword" method="POST" class="form">
    <div class="form-group">
            <label class="sr-only" for="username">New Password</label>
            <input type="text" id="password" name="password" class="form-control" placeholder="password">
	</div>
	<div class="form-group">
            <label class="sr-only" for="password2">Confirm New Password</label>
            <input type="text" id="password2" name="password2" class="form-control" placeholder="confirm password">
    </div>
	
	<button type="submit" class="btn btn-default">Update</button>
</form>

<%@include file="/WEB-INF/include/footer.jsp" %>