package com.mini_project.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini_project.Model.DAOServiceImpl;
import com.mini_project.Model.DAOservice;

@WebServlet("/getReg")
public class AllRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllRegistration() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(180);
			if (session.getAttribute("email") != null) {

				DAOservice service = new DAOServiceImpl();
				service.connectDB();

				ResultSet res = service.getReg();
				request.setAttribute("res", res);

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/searchResult.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("errorMsg", "Logged Out Login Again!");
				RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
				rd1.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sessionMsg", "Session Timeout!");
			RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
			rd1.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
