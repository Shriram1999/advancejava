package in.com.rays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCRUD {


	public static void main(String[] args) throws Exception {
		//testselect();
		testadd();

	}

	public static void testadd() throws Exception {
Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
		Statement stmt =conn.createStatement();
	int i = stmt.executeUpdate("insert into emp values(7,'ram','patel', 25001,'male',4)");
	
	System.out.println(i);
		
	}

	@SuppressWarnings("unused")
	private static void testselect() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
		Statement stmt =conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from emp");
	while (rs.next()) {
		System.out.print("\t"+rs.getString(1));
		System.out.print("\t"+rs.getString(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t"+rs.getString(4));
		System.out.println(rs.getString(5));
	}
		
	}

}

