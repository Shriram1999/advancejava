package in.com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.com.Authenticate.modelAuthenticate;
import in.com.Bean.UserRagistrationBean;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * String name = request.getParameter("email"); String value =
		 * request.getParameter("Password");
		 * 
		 * Cookie c = new Cookie(name, value);
		 * 
		 * c.setMaxAge(24*60*60);
		 * 
		 * response.a  ddCookie(c);
		 */
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		
		HttpSession session= req.getSession();
		UserRagistrationBean bean = new UserRagistrationBean();
		UserRagistrationmodel um = new UserRagistrationmodel();
		
		String email = req.getParameter("user");
		String password = req.getParameter("pwd");
		
		//  Ragics apply  //
		
		System.out.println("before");
		 String emailreg ="^[_A-Za-z0-9-]+(\\.[_A_Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		  String pwdreg="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		 System.out.println("after");
			
		  
		 
		  // required methods
					
	 	if(email.equals("") && password.equals("")){
			RequestDispatcher rd=req.getRequestDispatcher("Loginview1.jsp");
			req.setAttribute("one", "email and pwd is required");
			rd.forward(req, res);
		}
		else if(email.equals("")){
			RequestDispatcher rd=req.getRequestDispatcher("Loginview1.jsp");
			req.setAttribute("Email", "Email is Required");
			rd.forward(req, res);	
		}
		else if(password.equals("")){
			RequestDispatcher rd=req.getRequestDispatcher("Loginview1.jsp");
			req.setAttribute("Password", "Password is Rquired");
		rd.forward(req, res);		
		
	 	
	 	
	 	
	 	
	 	// forget methods
	 	
	 	
	 	
		
		}else if(!email.matches(emailreg) && !password.matches(pwdreg)){
			RequestDispatcher rd=req.getRequestDispatcher("loginview1.jsp");
			req.setAttribute("email", "email and password is required");
			rd.forward(req, res);
		}else if(!email.matches(emailreg)){
			RequestDispatcher rd=req.getRequestDispatcher("WelcomeView.jsp");
			req.setAttribute("email", "email is required");
			rd.forward(req, res);
		}else if(!password.matches(pwdreg)){
			RequestDispatcher rd=req.getRequestDispatcher("Loginview1.jsp");
			req.setAttribute("email", "password is required");
			rd.forward(req, res);
		}
	 	 	
		else {
			
		
		}
	 	
	 	
	 	// Authenticate method

		try {
			bean = um.modelauthenticate(email, password);
			if (bean !=null) {
				
				session.setAttribute("User", bean);
				RequestDispatcher rd = req.getRequestDispatcher("WelcomeCtl");
				System.out.println("first");
				rd.forward(req, res);
			} else {

				
				RequestDispatcher rd = req.getRequestDispatcher("Loginview1.jsp");
				System.out.println("second");
				req.setAttribute("Error", "Invalid Username & password");
				rd.forward(req, res);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}