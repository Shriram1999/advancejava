package in.com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.Bean.MarksheetBean;
import in.com.model.MarksheetDao;

@WebServlet(urlPatterns = "/MarksheetCtl")
public class MarksheetCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		MarksheetBean bean = new MarksheetBean();
		
		
		String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		int Roolno = Integer.parseInt(request.getParameter("rollNo"));
		int physics = Integer.parseInt(request.getParameter("physics"));
		int chemistry = Integer.parseInt(request.getParameter("chemistry"));
		int math = Integer.parseInt(request.getParameter("maths"));

		bean.setFname(fname);
		bean.setLname(lname);
		bean.setRoolno(Roolno);
		bean.setPhysics(physics);
		bean.setChemistry(chemistry);
		bean.setMath(math);

		MarksheetDao dao =  new MarksheetDao();

		
		if(fname.equals("")&& (lname.equals("")) ){
			RequestDispatcher rs = request.getRequestDispatcher("marksheet.jsp");
			request.setAttribute("one","Enter fNAME & LNAME");
			rs.forward(request, response);	
			
		}else if  (fname.equals("")){ 
			
			RequestDispatcher rs = request.getRequestDispatcher("marksheet.jsp");
			request.setAttribute("two","fname is Required");
			rs.forward(request, response);		
			
			
		}else if  (lname.equals("")){
			
			RequestDispatcher rs = request.getRequestDispatcher("marksheet.jsp");
			request.setAttribute("three","lname is Required");
			rs.forward(request, response);	
					
		}else {
		
			try {

				if (bean != null) {
			
					//	System.out.println("first");
				
					dao.add(bean);
					RequestDispatcher rs = request.getRequestDispatcher("marksheet.jsp");
					request.setAttribute("msg", "Record Inserted");
					rs.forward(request, response);
		
			
				}else {
					
					RequestDispatcher rs = request.getRequestDispatcher("marksheet.jsp");
				
					//System.out.println("second");

					request.setAttribute("Error","Invalid username & password");
					rs.forward(request, response);				
				}
					
		
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

	}
}

