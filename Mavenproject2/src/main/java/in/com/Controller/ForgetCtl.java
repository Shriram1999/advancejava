package in.com.Controller;


	

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.Bean.UserRagistrationBean;

@WebServlet("/ForgetCtl")
public class ForgetCtl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRagistrationBean bean = new UserRagistrationBean();
		UserRagistrationmodel model = new UserRagistrationmodel();
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		 try {	
			 bean = model.forgetPass(email);

/*      if (email.equals("")) {

	      RequestDispatcher rd = request.getRequestDispatcher("ForgetView.jsp");
	      request.setAttribute("email", "Username is required");
	      rd.forward(request, response);
         }
*/			
			 if(bean!= null) {
				 out.println("Your password is :"+bean.getPwd());				
			} else if (email.equals(""))  {
			RequestDispatcher rd = request.getRequestDispatcher("ForgetView.jsp");
			request.setAttribute("email", "please inter your email");
			rd.forward(request, response);
	    }else {
	    	RequestDispatcher rd = request.getRequestDispatcher("ForgetView.jsp");
			request.setAttribute("Pwd", "your email id is not valid");
			rd.forward(request, response);
	    	
	    }
			 
		 }
		 catch (Exception e) {
				e.printStackTrace();
			}

	
	
	
	
	
	
	}
	
	
}
