<%@page import="in.com.Bean.MarksheetBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ includefile= "Header.jsp" %>
	<form action="getmarksheetrollCTL" method="post">

		<%
			MarksheetBean bean = (MarksheetBean) request.getAttribute("send");
		%>


		<h1 align="center">Student Marksheet</h1>

		<table align="center">
			
			<tr>
				<th>Rollno :</th>
				<td><input type=name name="roolno" value=""placeholder="Enter Roll no."></td>
					
				<td><input type="submit" name="submit" value="search">
				</td>
			</tr>
			
			<br>
		</table>

		<table border="1" align="center"
			style="background-color: BurlyWood; text-align: center;" width="100%">



			<%
				if (bean !=null) {
			%>
			
			<tr>
				<th>ID</th>
				<td><%=bean.getId()%></td>
			</tr>

		
			<tr>
				<th>First Name</th>
				<td><%=bean.getFname()%></td>
			</tr>

			<tr>
				<th>Last Name</th>
				<td><%=bean.getLname()%></td>
			</tr>

<tr>
				<th>Roll NO</th>
				<td><%=bean.getRoolno()%></td>
			</tr>


			<tr>
				<th>Physics</th>
				<td><%=bean.getPhysics()%></td>
			</tr>


			<tr>

				<th>Chemistry</th>
				<td><%=bean.getChemistry()%></td>
			</tr>

			<tr>
				<th>Maths</th>
				<td><%=bean.getMath()%></td>
				<%
					}
				%>
			
		</table>
		<table align="center">
			
			<td><input type="submit" name="submit" value="Add"></td>
			
			<td><input type="submit" name="submit" value="Delete"></td>
			
		</table>

	</form>
	
	<%@include file="Footer.jsp"%>
	</tr>

	</form>

</body>
</html>

