<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Application Security Demo</title>
	<meta name="description" content="Simple Java webapp for demonstrating application security vulnerabilities.">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/main.css">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./">Application Security Demo</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="./">Comments</a></li>
					<li><a href="addMod.jsp">Add Moderator</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<% if (session.getAttribute("username") == null) { %>
						<li><a href="login.jsp">Sign In</a></li>
					<% } else { %>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= (String) session.getAttribute("username") %> <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="Logout">Sign Out</a></li>
							</ul> 
						</li>
					<% } %>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">