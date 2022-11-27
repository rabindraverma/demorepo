package com.mini_project.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini_project.Model.DAOServiceImpl;
import com.mini_project.Model.DAOservice;

@WebServlet("/reg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(180);
		if (session.getAttribute("email") != null) {

			DAOservice service = new DAOServiceImpl();
			service.connectDB();

			service.saveReg(name, city, email, mobile);
			request.setAttribute("msg", "Record is saved..");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
			rd.include(request, response);
		} else {
			request.setAttribute("errorMsg", "Logged Out Login Again!");
			RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
			rd1.forward(request, response);
		}

	}catch (Exception e) {
		request.setAttribute("sessionMsg", "Session Timeout!");
		RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
		rd1.forward(request, response);
	}
	}
}
