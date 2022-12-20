package in.com.Authenticate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import in.com.Bean.UserRagistrationBean;

public class modelAuthenticate {

	
	
	
	public UserRagistrationBean modelauthenticate (String email,String pwd) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		UserRagistrationBean bean =null;
		
		PreparedStatement ps= conn.prepareStatement(" Select * from ur where email=?,pwd=?");
		
		ps.setString(1, email);
		ps.setString(2, pwd);
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
			
		bean=new UserRagistrationBean();
		
		
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
		
}
