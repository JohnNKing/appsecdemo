<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, org.apache.commons.lang3.StringEscapeUtils, com.johnnking.csrf.UserManager, com.johnnking.csrf.User"%>
<%
	UserManager.init();
	List<User> users = UserManager.getUsers();
%>
<%@include file="/WEB-INF/include/header.jsp" %>

		Hello <%= StringEscapeUtils.escapeHtml4((String) session.getAttribute("username")) %><br><br>
	
		<div class="panel-heading"><h2>Users</h2></div>
		<ul class="list-group">
			<% for (User user : users) { %>
			<li class="list-group-item"><%= StringEscapeUtils.escapeHtml4(user.getName()) %></li>
			<% } %>
		</ul>
<%@include file="/WEB-INF/include/footer.jsp" %>
