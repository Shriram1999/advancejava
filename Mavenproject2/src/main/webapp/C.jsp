<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("car", "Kia");

		String a = (String) request.getAttribute("fruits");
		String b = (String) request.getAttribute("laptop");
		String c = (String) request.getAttribute("car");
	%>
	<%=a%>

	<%=b%>

	<%=c%>
</body>
</html>