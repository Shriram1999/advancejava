package in.com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.Bean.MarksheetBean;
import in.com.model.MarksheetDao;

@WebServlet("/GetmarksheetCtl")
public class GetmarksheetlistcCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     MarksheetBean bean = new MarksheetBean();
     MarksheetDao modal = new MarksheetDao();
		try {
			List list = modal.Getmarksheetlist(bean);
			RequestDispatcher rd = request.getRequestDispatcher("marksheetlistview.jsp");
			request.setAttribute("Lis", list);
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetDao modal = new MarksheetDao();
		
		bean.setFname(request.getParameter("name"));		
    
		//bean.setRoolno(Integer.parseInt(request.getParameter("Roolno"))); 
	

		 String op = request.getParameter("operation");
		 if(op.equals("Search")){
		try {
			
			List list =modal.Search(bean);
			RequestDispatcher rd = request.getRequestDispatcher("marksheetlistview.jsp");
			request.setAttribute("Lis", list);
			rd.forward(request, response);
		//	System.out.println("second");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
		

	}
}
