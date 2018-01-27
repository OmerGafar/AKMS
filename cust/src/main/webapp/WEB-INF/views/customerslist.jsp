<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.cust.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
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
		<p class="navbar-brand">AK-MS</p>
		<a class="navbar-brand" href="/cust/customer">Customers</a> <a
			class="navbar-brand" href="/cust/key">Key Management</a>
		<!--  <a class="navbar-brand" href="/cust/account">Accounts</a>
           <a class="navbar-brand" href="/cust/webserviceclient">Webservice Client</a> -->
	</div>
	<div id="navbar" class="navbar-collapse collapse"></div>
	<!--/.navbar-collapse -->
	</div>
	</nav>


	<%
String ctrl_url="/cust/customer";
Customer act = (Customer)request.getAttribute("cust");
boolean act_notnull = (null!=act); 
//List custs = (List)request.getAttribute("customers");
String str= ( null==request.getAttribute("message") ) ? "" :(String)request.getAttribute("message");
//sucess

%>
	<%=str %>

	<form action="<%=ctrl_url %>" method="post">
		<%=act_notnull?"<input type=\"hidden\" name=\"id\" value=\""+act.getCustId()+"\">":"" %>
		Name <input type="text" name="name" class="form-control"
			<%=act_notnull?"value=\""+act.getName()+"\"":"" %>><br />
		Email <input type="email" name="email" class="form-control"
			<%=act_notnull?"value=\""+act.getEmail()+"\"":"" %>><br />
		Phone <input name="phone" class="form-control" type="text"
			<%=act_notnull?"value=\""+act.getPhone()+"\"":"" %>><br />
		<!-- note <input type="text" name="note"><br/> -->
		<input type="submit" value="insert" class="btn btn-success"
			name="submit">
		<%=act_notnull?"<input type=\"submit\"  class=\"btn btn-success\" value=\"update\" name=\"submit\">":"" %>
		<%=act_notnull?"<input type=\"submit\"  class=\"btn btn-success\" value=\"delete\" name=\"submit\">":"" %>
	</form>

	<form action=<%=ctrl_url %>>
		Customer ID<input type="text" name="id2get" /> <input type="submit"
			value="get" class="btn btn-success" name="submit">
		<%-- <%=act_notnull?"<input type=\"submit\" value=\"update\">":"" %>
<%=act_notnull?"<input type=\"submit\" value=\"delete\">":"" %> --%>
	</form>

</body>
</html>