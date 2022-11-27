package com.mini_project.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini_project.Model.DAOServiceImpl;
import com.mini_project.Model.DAOservice;

@WebServlet("/for")
public class VerifyForget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public VerifyForget() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		request.setAttribute("email",email);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/forget.jsp");
		rd.forward(request, response);
		
		
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		DAOservice service=new DAOServiceImpl();
		service.connectDB();
		
		boolean status = service.verifyEmail(email);
		
		if (status==true) {
			RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
			rd1.forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "Invalid email..!");
			RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/views/forget.jsp");
			rd1.forward(request, response);
		}
	}

}
