package in.com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.com.Bean.MarksheetBean;

public class Studentmodel {
	
	
	
	

	public void add(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("insert into Student values(?,?,?,?,?)");

		ps.setInt(1, nextpk());
		ps.setString(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setString(5, bean.getSession());

		ps.executeUpdate();
		conn.commit();

		ps.close();
		conn.close();

	}

	// nextpk.....

	public Integer nextpk() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from Student");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	// Update.......

	public static void update(StudentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("update Student set Rollno=?,fname=?,lname=?,session =? where id=?");
				
		ps.setString(1, bean.getRollno());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());				
		ps.setString(4, bean.getSession());
		ps.setInt(5, bean.getId());
		
		ps.executeUpdate();
		conn.commit();

		ps.close();
		ps.close();

	}
	// delete..........

	public static void delete(StudentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("delete from Student where id =?");

		ps.setInt(1, bean.getId());

		ps.executeUpdate();
		conn.commit();
		conn.close();
		ps.close();

	}

	// maritlist

	public List getmaritlist(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		ArrayList list = new ArrayList();

		PreparedStatement ps = conn.prepareStatement("select * ,(physics+chemistry+math)AS total from Student order by total desc limit 10");


		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
		bean.setSession(rs.getString(5));
	

			list.add(bean);
		}
		ps.close();
		conn.close();
		return list;
	}

	// getbyroolno.........../

	public StudentBean getbyroolno(String roolno) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");
		StudentBean bean = null;
                                    
		PreparedStatement ps = conn.prepareStatement("select * from Student where roolno=? ");

		ps.setString(1, roolno);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setRollno(rs.getString(4));
			bean.setSession(rs.getString(5));
			
		}
		ps.close();
		conn.close();
		rs.close();
		return bean;

	}

}
