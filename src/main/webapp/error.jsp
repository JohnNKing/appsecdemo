<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@include file="/WEB-INF/include/header.jsp" %>
<%
String error = request.getParameter("error");
if (error == null) {
	error = "An error occurred";
}
%>

<div class="alert alert-danger" role="alert">
	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	<span class="sr-only">Error:</span> 
	<%= error %>
</div>

<%@include file="/WEB-INF/include/footer.jsp" %>