package com.mini_project.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini_project.Model.DAOServiceImpl;
import com.mini_project.Model.DAOservice;


@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	
	request.setAttribute("email",email);
	request.setAttribute("mobile",mobile);
	
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateRegistration.jsp");
	rd.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOservice service =new DAOServiceImpl();
		service.connectDB();
		
		service.updateReg(email,mobile);
		
		ResultSet res = service.getReg();
		request.setAttribute("res", res);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/searchResult.jsp");
		rd.forward(request, response);
		
	}

}
