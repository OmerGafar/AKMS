<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cust.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>web service client</title>
</head>
<body>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

	<nav class="navbar navbar-inverse ">
	<div class="container">
		<!--       <div class="navbar-header">
           <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
             <span class="sr-only">Toggle navigation</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
           </button> -->

		<a class="navbar-brand" href="/cust/customer">Customers</a> <a
			class="navbar-brand" href="/cust/account">Accounts</a> <a
			class="navbar-brand" href="/cust/webserviceclient">Webservice
			Client</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse"></div>
	<!--/.navbar-collapse -->
	</div>
	</nav>
	<%=( null==request.getAttribute("response") ) ? "" :((ResponseMessage)request.getAttribute("response")).getBody() %></br>
	<form method="post">
		Account ID <input type="text" name="act1"></br> Password <input
			type="password" name="pin"></br> Transfer To (Account ID) <input
			type="text" name="act2"></br> Value to tarnsfer <input type="text"
			name="val"></br> <input type="submit" name="submit"
			value="tranfer"></br>
	</form>
</body>
</html>