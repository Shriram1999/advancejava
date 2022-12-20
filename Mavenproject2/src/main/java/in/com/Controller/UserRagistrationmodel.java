package in.com.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import in.com.Bean.MarksheetBean;
import in.com.Bean.UserRagistrationBean;

public class UserRagistrationmodel {

	// nextpk.....
	public int nextpk() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from ur");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public void add1(UserRagistrationBean bean) throws Exception {

		// Add....

		// nextpk();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("insert into ur values(?,?,?,?,?,?,?)");

		ps.setInt(1, nextpk());

		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setString(4, bean.getGender());
		ps.setString(5, bean.getEmail());
		ps.setString(6, bean.getCpwd());
		ps.setString(7, bean.getCpwd());

		ps.executeUpdate();
		conn.commit();

		ps.close();
		conn.close();

	}

	public UserRagistrationBean modelauthenticate(String email, String pwd) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		UserRagistrationBean bean = null;

		PreparedStatement ps = conn.prepareStatement(" Select * from ur where email=? and pwd=?");

		ps.setString(1, email);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			bean = new UserRagistrationBean();

			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setPwd(rs.getString(6));
			bean.setCpwd(rs.getString(7));

		}
		conn.close();
		return bean;
	}
	
	public UserRagistrationBean forgetPass(String email) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");
		UserRagistrationBean bean=null;
		PreparedStatement ps = conn.prepareStatement("select*from ur where email=?");
		ps.setString(1, email);
	
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			bean =new UserRagistrationBean();
			bean.setPwd(rs.getString(6));
		}
		return bean;
	
	
	
	
	
	}

	
	public void UserRagistrationBean(UserRagistrationBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		conn.setAutoCommit(false);
		  
          PreparedStatement ps = conn.prepareStatement("delete from marksheet where id =?");
          
	ps.setInt(1, bean.getId());
	
	ps.executeUpdate();
	conn.commit();
	conn.close();
	ps.close();   
		
	}

	public void delete(in.com.Bean.UserRagistrationBean bean) {
		// TODO Auto-generated method stub
		
	}
	
		
	}
	
	


