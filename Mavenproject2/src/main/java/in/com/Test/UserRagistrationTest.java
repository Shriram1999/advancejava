package in.com.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.com.Authenticate.modelAuthenticate;
import in.com.Bean.MarksheetBean;
import in.com.Bean.UserRagistrationBean;
import in.com.Controller.UserRagistrationmodel;
import in.com.model.MarksheetDao;

public class UserRagistrationTest {  

	static UserRagistrationmodel model = new UserRagistrationmodel();

	public static void main(String[] args) throws Exception {

		testadd();
		//testGetmarksheetlist();
	//testgetbyroolno();
	}

	private static void testgetbyroolno() throws Exception {
		
		MarksheetBean bean =new MarksheetBean();
		MarksheetDao dao = new MarksheetDao();		
		bean =dao.getbyroolno("110");
		
		
		System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getRoolno());
		System.out.print("\t"+bean.getPhysics());
		System.out.print("\t"+bean.getChemistry());
		System.out.println("\t"+bean.getMath());
		
	}

	public static void testGetmarksheetlist() throws Exception {
	
		MarksheetBean bean = new MarksheetBean();
		MarksheetDao dao = new MarksheetDao();
		List list = new ArrayList();
		list =dao.getmaritlist(bean);
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
		bean =(MarksheetBean)it.next();	
		
		System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getRoolno());
		System.out.print("\t"+bean.getPhysics());
		System.out.print("\t"+bean.getChemistry());
		System.out.println("\t"+bean.getMath());	
			
		}
		
		
		
		
	}

	public static void testadd() throws Exception {

		UserRagistrationBean bean = new UserRagistrationBean();
		bean.setFname("praveen");
		bean.setLname("mandloi");
		bean.setGender("male");
		bean.setEmail("smziddi1@gmail.com");
		bean.setPwd("75002");
		bean.setCpwd("75002");

		model.add1(bean);
		System.out.println("inserted");
	}

	
	
	


public static void testdelete() throws Exception {

	UserRagistrationBean bean = new UserRagistrationBean();



     model.delete(bean);
	System.out.println("inserted");
}
}

/*
 * <servlet> <servlet-name>HelloServlet</servlet-name>
 * <display-name>HelloServlet</display-name> <description></description>
 * <servlet-class>in.com.servlet.HelloServlet</servlet-class> </servlet>
 * <servlet-mapping> <servlet-name>HelloServlet</servlet-name>
 * <url-pattern>/HelloServlet</url-pattern> </servlet-mapping>
 */
