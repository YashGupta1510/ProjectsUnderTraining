package com.nagarro.forget;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Forget")
public class Forget extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			ForgetDao dao = new ForgetDao();
			if (dao.checkLogin(uname, pass)) {
				response.sendRedirect("login.jsp");
			} else {
				response.sendRedirect("ForgetPassword.jsp");
			}
		} catch (Exception e) {
			System.out.println("Exception Occur" + e.getMessage());
		}
	}

}