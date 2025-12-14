package com.cdac;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet
{


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if(session == null){
		    res.sendRedirect("login.html");
		    return;
		}
		List<Employee> list = null;
		
		EmpDao ed = new EmpDao();
		
		try {
			list = ed.viewEmp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("viewEmployee", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("ViewEmployee.jsp");
		rd.forward(req, res);
	}
}
