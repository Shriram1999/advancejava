<%@page import="in.com.Bean.UserRagistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% UserRagistrationBean been = (UserRagistrationBean) session.getAttribute("User");
boolean userLoggedIn = been != null;

%>
      

<a href="">Welcome</a>

<% if(userLoggedIn) {%>

<a href="Logout.jsp">Logout</a><h3>Hi,<%=been.getFname() %></h3>
<%}else{ %>


<a href="Loginview1.jsp">Login</a>
<h3>Hi,Guest</h3>

<%} %>

<img align="right" style="width: 180px; height: 80px;" alt="rayslogo"
 src="img/logo.png">
<br>
<br>
   
<a href="getmarksheetrollCTL">Get Marksheet</a>|
<a href="">Merit Marksheet List</a>|
<a href="">Change Password</a>|
<a href="">Java Doc</a>|
<a href="">Add Marksheet</a>|
<a href="GetmarksheetCtll">Marksheet List</a>|
<a href="">Add User</a>|
<a href="">Usewr List</a>|
<a href="">Add College</a>|
<a href="">College List</a>|
<a href="">Add Student</a>|
<a href="">Student List</a>|
<a href="">Add Role</a>|
<a href="">Role List</a>||
<br>
<br>
<HR>

</body>
</html>