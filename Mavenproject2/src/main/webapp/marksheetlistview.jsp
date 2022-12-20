<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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

<%MarksheetBean bean = new MarksheetBean();
 List list =(List) request.getAttribute("Lis");
  Iterator<MarksheetBean> it = list.iterator();



%>

<form action="GetmarksheetCtl" method="post">

  
<h1 align="center">Marksheet records</h1>

<table width="100%">
                <tr>
                    <td align="center"><label> Name :</label> <input type="text" name="name" value="">
                        &emsp; <label>RollNo :</label> <input type="number" name="roolno" value="">&emsp;
                        <input type="submit" name="operation" value="Search">
                    
                    </td>
                </tr>
            </table>
            
		<table border="1" align="center" style="background-color: BurlyWood; text-align: center;" width="100%">
		
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Roll NO</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Maths</th>
			</tr>
			<%
			while(it.hasNext()){
				bean=it.next();
			
			%>
			<tr>
			<td><%=bean.getId() %></td>
			<td><%=bean.getFname() %></td>
			<td><%=bean.getLname() %></td>
			<td><%=bean.getRoolno() %></td>
			<td><%=bean.getPhysics() %></td>
			<td><%=bean.getChemistry() %></td>
			<td><%=bean.getMath() %></td>
			
					
			</tr>
			
			<%
			}
			%>
			
		</table>

 <table width="100%">
                <tr>
                    <td><input type="submit" name="operation" value="Previous"></td>
                    <td><input type="submit" name="operation" value="New"></td>
                    <td><input type="submit" name="operation" value="Delete"></td>
                    <td align="right"><input type="submit" name="operation" value="Next"></td>
                </tr>
            </table>

</form>
	
</body>
</html>
