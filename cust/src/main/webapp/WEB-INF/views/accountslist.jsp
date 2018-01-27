<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.cust.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
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
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="/cust/customer">Customers</a> <a
				class="navbar-brand" href="/cust/account">Accounts</a> <a
				class="navbar-brand" href="/cust/webserviceclient">Webservice
				Client</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse"></div>
		<!--/.navbar-collapse -->
	</div>
	</nav>


	<%
String ctrl_url="/cust/account";
Account act = (Account)request.getAttribute("account");
boolean act_notnull=(act!=null);
/* 
List acts = (List)request.getAttribute("accounts");
for (Iterator iterator =  acts.iterator(); iterator.hasNext();){
    Account act = (Account) iterator.next();    
    out.print("First Name: " + act.getAct_no()); 

 } 
*/
boolean sucess= (Boolean)request.getAttribute("sucess");
%>
	<%=sucess?":)":"Opreation failed ... :(" %>
	<br />
	<br />
	<form action=<%=ctrl_url %>>
		Account ID <input type="text" name="id" class="form-control "
			<%=act_notnull?"value=\""+act.getAct_id()+"\"":"" %>> <br />
		<input type="submit" name="submit" value="get" class="btn btn-success"><br />
		<br />Opeartion type:<br />
		<input type="radio" name="opration" value="cr" checked> Credit
		<input type="radio" name="opration" value="dr"> Depit <br />
		<br />Value <input type="text" name="value" class="form-control">
		<%if(null!=act){ %>
		<input type="submit" name="submit" value="ok" class="btn btn-success"><br />
		Account NO :
		<%=act.getAct_no() %><br /> Balnace :
		<%=act.getBalance() %><br /> Statues :
		<%=act.getSataus() %><br /> Note :
		<%=act.getNote() %><br /> <input type="submit" name="submit"
			value="close" class="btn btn-success"><br /> <br />
		Transfer to <input type="text" name="toid"><br /> Value to
		Transfer<br /> <input type="text" name="transfervalue"><br />
		<input type="submit" name="submit" value="transfer"
			class="btn btn-success"><br />
		<%} %>
	</form>
</body>
</html>