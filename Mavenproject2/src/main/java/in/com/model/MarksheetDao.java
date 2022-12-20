package in.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.com.Bean.MarksheetBean;


/**
 * @author Shriram Patel
 *
 */
public class MarksheetDao {

	
	public static MarksheetBean bean;
	private ArrayList Arraylist;
	private List list;



	public void add(MarksheetBean bean ) throws Exception {
	 
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		conn.setAutoCommit(false);
		
		PreparedStatement ps= conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		
		
		ps.setInt(1, nextpk());
		
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setInt(4,bean.getRoolno());
		ps.setInt(5,bean.getPhysics());
		ps.setInt(6,bean.getChemistry());
		ps.setInt(7,bean.getMath());
		
		
		ps.executeUpdate();
		conn.commit();
		
		ps.close();
		conn.close();
			
	}

	//nextpk..... 
	
	public Integer nextpk() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		int pk=0;
		PreparedStatement ps= conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		
		
		return pk+1;

	}
		
	
	//Update.......
		
	public static void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
		conn.setAutoCommit(false); 
          
          PreparedStatement ps = conn.prepareStatement("update marksheet set fname=?,lname=?,Roolno=?,physics =?, chemistry =? ,math =? where id=?");
          
          ps.setString(1, bean.getFname());
          ps.setString(2, bean.getLname());
          ps.setInt(3, bean.getRoolno());
          ps.setInt(4, bean.getPhysics());
          ps.setInt(5, bean.getChemistry());
          ps.setInt(6, bean.getMath());
          ps.setInt(7, bean.getId());
        
    ps.executeUpdate();
    conn.commit();
   
    ps.close();
    ps.close(); 
      
	}	
	    // delete..........
	
	
	
	
	public static void delete(MarksheetBean bean) throws Exception {
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
	
	          // maritlist
	
	public List getmaritlist(MarksheetBean bean)throws Exception {
		
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		
        ArrayList list =new ArrayList();
          
          PreparedStatement ps = conn.prepareStatement("select * ,(physics+chemistry+math)AS total from marksheet order by total desc limit 10");
          
          ResultSet rs = ps.executeQuery();
       
          while (rs.next()) {
			
        	  	bean =new MarksheetBean();
        	  	
        	    bean.setId(rs.getInt(1));      
       			bean.setFname(rs.getString(2));
       			bean.setLname(rs.getString(3));
       			bean.setRoolno(rs.getInt(4));
       			bean.setPhysics(rs.getInt(5));
       			bean.setChemistry(rs.getInt(6));
       			bean.setMath(rs.getInt(7));
       		
       			list.add(bean);	
		}        
          ps.close();
          conn.close();
          return list;
}

	// getbyroolno.........../
	
	
public MarksheetBean getbyroolno(String roolno) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
	MarksheetBean bean =null;
	  
	 PreparedStatement ps = conn.prepareStatement("select * from marksheet where roolno=? ");
  
	 ps.setString(1, roolno);
	 ResultSet rs = ps.executeQuery();
	 
	 
	   while (rs.next()) {
		bean=new MarksheetBean();
		 
		 bean.setId(rs.getInt(1));
		 bean.setFname(rs.getString(2));
		 bean.setLname(rs.getString(3));
		 
		 bean.setRoolno(rs.getInt(4));
		 bean.setPhysics(rs.getInt(5));
		 bean.setChemistry(rs.getInt(6));
		 bean.setMath(rs.getInt(7));
		 	
	}
 
  return bean;
	
  
  // get mARKSHEET LIST
  
}
public List Getmarksheetlist(MarksheetBean bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
	ArrayList list =new ArrayList();
	 // System.out.println("3");
      PreparedStatement ps = conn.prepareStatement("Select * from marksheet");
      
      ResultSet rs =ps.executeQuery();
    //  System.out.println("4");
	while(rs.next()) {
		
		bean =new MarksheetBean();
		bean.setId(rs.getInt(1));
		bean.setFname(rs.getString(2));
		bean.setLname(rs.getString(3));
		bean.setRoolno(rs.getInt(4));
		bean.setPhysics(rs.getInt(5));
		bean.setChemistry(rs.getInt(6));
		bean.setMath(rs.getInt(7));
		list.add(bean);
	}
	//System.out.println("5");
	conn.close();
	ps.close();
	rs.close();
	return list;
	
	}

//Search


public List Search(MarksheetBean bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
	
	List list = new ArrayList();
	StringBuffer sb= new StringBuffer("select * from marksheet where 1=1");
	if(bean!=null){
		if(bean.getId()>0){
			sb.append(" AND id ="+bean.getId());
		}
		if(bean.getRoolno()>0){
			sb.append(" AND Roolno like '"+bean.getRoolno()+"%'");		
		}
		
		if(bean.getFname()!=null && bean.getFname().length()>0){
			sb.append(" AND Fname like '"+bean.getFname()+"%'");	
		}
		if(bean.getLname()!=null && bean.getLname().length()>0){
			sb.append(" AND Lname like '"+bean.getLname()+"%'");	
		}
		}
	PreparedStatement ps = conn.prepareStatement(sb.toString());
	ResultSet rs =ps.executeQuery();
	while (rs.next()) {
		bean= new MarksheetBean();
		bean.setId(rs.getInt(1));

		bean.setFname(rs.getString(2));
		bean.setLname(rs.getString(3));
		bean.setRoolno(rs.getInt(4));
		bean.setPhysics(rs.getInt(5));
		bean.setChemistry(rs.getInt(6));
		bean.setMath(rs.getInt(7));
		
		list.add(bean);
	}
	conn.close();
	ps.close();
	rs.close();
	return list;
	}
	
	
}
