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


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOservice service=new DAOServiceImpl();
		service.connectDB();
		
		boolean status = service.verifyCredentials(email, password);
		
			if (status==true) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setMaxInactiveInterval(60);
				RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
				rd1.forward(request, response);
			}else {
				
				request.setAttribute("errorMsg", "Invalid user name / password");
				RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
				rd1.forward(request, response);
			}
		}
	}

