package com.cdac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession session = req.getSession(false);
		
		if(session == null)
		{
			res.sendRedirect("login.html");
			return;
		}
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		
		Employee e = new Employee(name, email, course);
		
		EmpDao ed = new EmpDao();
		int status = 0;
		try {
			status = ed.insertEmp(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(status>0)
		{
			
			res.sendRedirect("success.jsp");
		}
		else {
			res.sendRedirect("error.html");
		}
	}
}
