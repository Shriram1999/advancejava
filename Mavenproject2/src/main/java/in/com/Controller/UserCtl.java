package in.com.Controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.Bean.UserRagistrationBean;

@WebServlet(name = "UserCtl" ,urlPatterns = "/UserCtl")         // url mapping

public class UserCtl extends HttpServlet {

	public UserCtl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PrintWriter out =response.getWriter();
		// out.println("First Servlet");

		UserRagistrationBean bean = new UserRagistrationBean();
		// System.out.println("ctl");
		bean.setFname(request.getParameter("fname"));
		bean.setLname(request.getParameter("lname"));
		bean.setGender(request.getParameter("gender"));
		bean.setEmail(request.getParameter("email"));
		bean.setPwd(request.getParameter("pwd"));
		bean.setCpwd(request.getParameter("cpwd"));

		UserRagistrationmodel um = new UserRagistrationmodel();

		try {
			um.add1(bean);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRagistrationBean bean = new UserRagistrationBean();
		// System.out.println("ctl");
		bean.setFname(request.getParameter("fname"));
		bean.setLname(request.getParameter("lname"));
		bean.setGender(request.getParameter("gender"));
		bean.setEmail(request.getParameter("email"));
		bean.setPwd(request.getParameter("pwd"));
		bean.setCpwd(request.getParameter("cpwd"));

		UserRagistrationmodel um = new UserRagistrationmodel();

		try {
			um.add1(bean);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
