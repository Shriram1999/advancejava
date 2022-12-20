package in.com.JDbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test_pre_Statement_add {

	public static void main(String[] args) throws Exception {
		
		testadd();
		//testupdate();
		 // testgetbyid(5);
		 // testdelete();
		  // testselect();
		    // nextpk();
	}
	      
	      // add
	
	private static void testadd() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
          int id =1;
          String fname ="rupuli";
          String lname ="Patel";
          int salary =25000;
          String gender ="female";
          int dept_id = 5;
         
          
          PreparedStatement ps = conn.prepareStatement("insert into emp values(?,?,?,?,?,?)");
          
          ps.setInt(1, id);
          ps.setString(2, fname);
          ps.setString(3, lname);
          ps.setInt(4, salary);
          ps.setString(5,gender);
          ps.setInt(6, dept_id);
        
        int i=  ps.executeUpdate();
          
          System.out.println(i+"inserted");
          ps.close();
          ps.close();
          
	}

	//updated//
	
	private static void testupdate() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
          int id =7;
          String fname ="ram";
          String lname ="patel";
          int salary =48000;
          String gender ="male";
          int dept_id = 5;
         
          
          PreparedStatement ps = conn.prepareStatement("update emp set fname =?, lname=?,salary=?,gender=?,dept_id =? where id =?");
          
      
          ps.setString(1, fname);
          ps.setString(2, lname);
          ps.setInt(3, salary);
          ps.setString(4,gender);
          ps.setInt(5, dept_id);
          ps.setInt(6, id);
        
        int i=  ps.executeUpdate();
          
          System.out.println(i+"updated");
          ps.close();
          ps.close();
	
	}
	//   get by id //
	
	private static void  testgetbyid(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
         
          
          PreparedStatement ps = conn.prepareStatement("select * from emp where id =?");
          
          ps.setInt(1, id);
	
	ResultSet set  = ps.executeQuery();
	
	 
	while (set.next()) {
		
		System.out.print("\t"+set.getInt(1));
		System.out.print("\t"+set.getString(2));
		System.out.print("\t"+set.getString(3));
		System.out.print("\t"+set.getInt(4));
		System.out.print("\t"+set.getString(5));
		System.out.println("\t"+set.getInt(6));
			
	}
	conn.close();
	ps.close();
	set.close();
	
	}
	
	     //delete test //
	
	private static void testdelete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
		int id =7;
		
		PreparedStatement ps = conn.prepareStatement("delete from emp where id=?");
		ps.setInt(1, id);
		
        int x = ps.executeUpdate();
             System.out.println(x +"deleted");
             ps.close();
             conn.close();
	}
	
	     // select test
	
	
	private static void testselect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from emp");
		ResultSet r  = ps.executeQuery();
		
		while (r.next()) {
			
			System.out.print("\t"+r.getInt(1));
			System.out.print("\t"+r.getString(2));
			System.out.print("\t"+r.getString(3));			
			System.out.print("\t"+r.getInt(4));
			System.out.print("\t"+r.getString(5));
			System.out.println("\t"+r.getInt(6));
			
		}
		r.close();
		ps.close();
		conn.close();
	}
	private static int nextpk() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
		int pk =0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from emp");
		ResultSet rs  = ps.executeQuery();
		while (rs.next()) {
			pk =rs.getInt(1);
			
		}
		return pk+1;
	}
}