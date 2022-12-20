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

@WebServlet("/getmarksheetrollCTL")
public class getmarksheetrollCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public getmarksheetrollCtl() {
     
    }  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

		String roolno =(request.getParameter("roolno"));
		MarksheetBean bean = new MarksheetBean();
		MarksheetDao dao = new MarksheetDao();
		
		
		try {
			
			bean =dao.getbyroolno(roolno);
			if(bean !=null){
			RequestDispatcher rd =request.getRequestDispatcher("getmarksheetrollview.jsp");
			request.setAttribute("send", bean);
			rd.forward(request, response);
			
		}	else {
			
			RequestDispatcher rd =request.getRequestDispatcher("getmarksheetrollview.jsp");
			request.setAttribute("Error","Rool no not found" );
			rd.forward(request, response);	
		}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);		
		
	}

}
