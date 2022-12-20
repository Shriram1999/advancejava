u<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String s = (String) request.getAttribute("msg");
		if (s != null) {
	%>
	<h1><%=s%></h1>
	<%
		}
	%>
	<center>
		<form action="MarksheetCtl" method="post">
			<h1>Add Marksheet</h1>
			<table>
				
				<tr>
					<th>First Name*</th>
					<td><input type="text" name="Fname" value=""></td>

				</tr>
				<tr>
					<th>Last Name*</th>
					<td><input type="text" name="Lname" value=""></td>

				</tr>
				<tr>
					<th>Rollno*</th>
					<td><input type="text" name="rollNo" value=""></td>
				</tr>
				<tr>
					<th>Physics</th>
					<td><input type="text" name="physics" value=""></td>
				</tr>
				<tr>
					<th>Chemistry</th>
					<td><input type="text" name="chemistry" value=""></td>
				</tr>
				<tr>
					<th>Maths</th>
					<td><input type="text" name="maths" value=""></td>

				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="operation" value="Save"> <input type="submit"
						name="operation" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</cente>
</body>
</html>