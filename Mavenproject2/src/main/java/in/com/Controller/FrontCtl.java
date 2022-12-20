package in.com.Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontCtl",urlPatterns = "*.do")
public class FrontCtl implements Filter {

   
	public FrontCtl() {
       
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
		
		
		
		HttpServletRequest Request =(HttpServletRequest)request;
		
		HttpSession session =Request.getSession();
		
		if (session.getAttribute("user")==null)   {

			request.setAttribute("Error", "Session is Expired pls Login Again");
		
			RequestDispatcher rd =Request.getRequestDispatcher("LoginCtl");
			
			rd.forward(Request, response);
			
			
		}
		}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
}

