<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form>
<% 

String user = request.getParameter("user");
String pwd = request.getParameter("pwd");


%>
<h1 align="center">User Ragistration</h1>
<table align ="center">

<tr>    
<th> user  </th>
<td> <%=user %>  </td>
 </tr>


<tr>    
<th> pwd  </th>
<td> <%=pwd %>  </td>
 </tr>







 </form>
 </table>
</body>
</html>