package in.com.JDbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test_pre_Statementcroud_All {

	public static void main(String[] args) throws Exception {
		
		testselect();

	}

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
		System.out.println("\t"+rs.getString(5));
	}
		rs.close();
		stmt.close();
	}    

}