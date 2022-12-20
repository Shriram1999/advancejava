<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">User Ragistration</h1>
	<form action="Userdata.jsp" method="get">

		<table>

			<tr>
				<th>First Name</th>
				<td><input type="text" Name="fname" value=""></td>
			</tr>


			<tr>
				<th>Last Name</th>
				<td><input type="text" Name="lname" value=""></td>
			</tr>


			<tr>
				<th>Gender</th>
				<td><input type="radio" Name="gender" value="male">
					male <input type="radio" Name="gender" value="Female">Female</td>
			</tr>


			<tr>
				<th>Email id</th>
				<td><input type="email" Name="email" value=""></td>
			</tr>

			<tr>
				<th>password</th>
				<td><input type="password" Name="pwd" value=""></td>
			</tr>


			<tr>
				<th>confirm Password</th>
				<td><input type="password" Name="cpwd" value=""></td>
			</tr>


			<tr>
				<th></th>
				<td><input type="submit" value="Sign up"> <input type="reset" value="Cancel"></td>
					
			</tr>




		</table>

	</form>

</body>
</html>