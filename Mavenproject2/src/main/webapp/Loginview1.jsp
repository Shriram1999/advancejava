<%@page import="javax.swing.text.Style"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login view </title>			
</head>
<body>


<%@include file = "Header.jsp"%>


	<form action="LoginCtl" method="post">

		<%
			String one = (String) request.getAttribute("one");
			String Email = (String) request.getAttribute("Email");
			String pwd = (String) request.getAttribute("Password");
		%>


		<h1 align="center">Login</h1>

		<%
			if (one != null) {
		%>
		<h3 style="color: red" align="center"><%=one%></h3>

		<%
			}
		%>



		<table align="center">
			<tr>
				<th>User Name*:</th>

				<td><input type="Text" name="user" value=""
					placeholder="Enter your Username">
					<%
						if (Email != null) {
					%><%=Email%>
					<%
						}
					%></td>

<%

if (Email !=null){
	
}

%>

		</tr>

			<tr>
				<th>Password*:</th>
				<td><input type="password" Name="pwd" value=""
					placeholder="Enter your Password">
					
					<%
						if (pwd != null) {
					%><%=pwd%>
					<%
						}
					%></td>
			
			</tr>

			<tr>
				<th>Submit</th>
				<td><input type="submit" name="Submit" value="login"></td>
			</tr>

			<tr>
				<th>Reset</th>
				<td><input type="Reset" name="Reset" value="cancel"></td>
			</tr>
		</table>
	</form>

	<center>
		<a href="UserRagistrationView.jsp">Create an Account</a> |<a href="ForgetView.jsp">Forget Password</a>
		<%@include file = "Footer.jsp"%>
			
	</center>

</body>
</html>