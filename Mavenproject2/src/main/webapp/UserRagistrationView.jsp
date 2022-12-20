<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserCtl" method ="post">
<h1 align="center">User Ragistration</h1>
	<table align="center">

		<tr>
			<th>first name</th>
			<td><input type ="text" name="fname" value=""></td>
		</tr>


		<tr>
			<th>last name</th>
			<td><input type ="text" name="lname" value=""></td>
		</tr>


		<tr>
			<th>gender</th>
			<td><input type ="radio" name="gender" value="male">male<input type ="radio" name="gender" value="female">female</td>
		</tr>


		<tr>
			<th>email</th>
			<td><input type ="email" name="email" value=""></td>
		</tr>



		<tr>
			<th>password</th>
			<td><input type ="password" name="pwd" value=""></td>
		</tr>


		<tr>
			<th>confirm paasword</th>
			<td><input type ="confirm password" name="cpwd" value=""></td>
		</tr>

  
             tr>
			<th></th>
			<td><input type ="submit"  value="signup"><input type ="reset"  value="cancle"></td>
		</tr>

		</form>
	</table>


</body>
</html>