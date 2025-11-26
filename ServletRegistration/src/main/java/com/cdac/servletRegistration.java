package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class servletRegistration extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("name");
		String sid = request.getParameter("prn");
		String mail = request.getParameter("email");
		
		Student s = new Student(uname, sid, mail);
		
		StudentDao sdao = new StudentDao();
		boolean status = false;
		
		try {
			status = sdao.saveStudent(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status)
		{
			out.println("<h2>Registered Successfully</h2>");
		}
		else {
			out.println("<h2>error in registration<h2>");
		}
		
	}
}
