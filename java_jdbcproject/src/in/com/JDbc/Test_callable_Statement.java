package in.com.JDbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Test_callable_Statement {

	public static void main(String[] args) throws Exception {

		testcallable();
	}

	private static void testcallable() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		CallableStatement cal = conn.prepareCall("{call empcounts(?, ?)}");

		cal.setInt(1, 2);
		
		// cal.setString(2, "naman");
		// cal.registerOutParameter(2, Types.INTEGER);
		cal.registerOutParameter(2, Types.VARCHAR);
		cal.execute();
		// System.out.println(cal.getInt(1));
		System.out.println(cal.getString(2));

	}

	// integer //

	/*
	 * private static void testcallable() throws Exception {
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * Connection conn =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root",
	 * "root");
	 * 
	 * CallableStatement cal= conn.prepareCall("{call emp(?)}");
	 * 
	 * cal.registerOutParameter(1, Types.INTEGER); //ragister out parameters//
	 * cal.execute(); System.out.println(cal.getInt(1));
	 * 
	 * 
	 * }
	 */

}
