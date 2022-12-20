package in.com.Marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetDAo {
	
	//private static final String roolno = null;
	static MarksheetDao dao = new MarksheetDao();

	
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
    	//testgetroolno();
			testgetmaritlist();	
	}

	public static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		
		bean.setFname("sagar");
		bean.setLname("mandloi");
		bean.setRoolno(565);
		bean.setPhysics(66);
		bean.setChemistry(32);
		bean.setMath(75);

		
		dao.add(bean);
		System.out.println("inserted");
	}
     
	// update......
	
	public static void testupdate() throws Exception {

		MarksheetBean x = new MarksheetBean();

		x.setId(1);
	x.setFname("anjali");
	x.setLname("sharma");
	x.setRoolno(112);
	x.setPhysics(55);
	x.setChemistry(89);
	x.setMath(56);
	
	dao.update(x);
	System.out.println("update");
	
	
	}    // delete
	
	public static void testdelete() throws Exception {

		MarksheetBean y = new MarksheetBean();

    y.setId(5);
    dao.delete(y);
    System.out.println("record deleted");
	
}
	
	//marit list........
	
	
	public static void testgetmaritlist() throws Exception {
    MarksheetBean bean = new MarksheetBean();
      List list = new ArrayList();
		list =dao.getmaritlist(bean);
		
		Iterator it =list.iterator() ;
		while(it.hasNext()) {
     bean= (MarksheetBean) it.next();
      System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getRoolno());
		System.out.print("\t"+bean.getPhysics());
		System.out.print("\t"+bean.getChemistry());
		System.out.println("\t"+bean.getMath());
		}
		
		
}
                // getby rollno....
	
	
	public static void testgetroolno() throws Exception {

		MarksheetBean bean = dao.getbyroolno("110");
		
		System.out.print("\t" +bean.getId());
		System.out.print("\t" +bean.getFname());
		System.out.print("\t" +bean.getLname());
		System.out.print("\t" +bean.getRoolno());
		System.out.print("\t" +bean.getPhysics());
		System.out.print("\t" +bean.getChemistry());
		System.out.println("\t" +bean.getMath());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}

}
