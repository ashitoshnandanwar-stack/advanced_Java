package com.cdac;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet
{
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	 {
		 String name = req.getParameter("name");
		 String email = req.getParameter("email");
		 String course = req.getParameter("course");
		 
		 int status = 0;
		 Student s = new Student(name, email, course);
		 
		 StudentDAO sd = new StudentDAO();
		 
		 try {
			status = sd.writeStudent(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		 
		 if(status > 0) {
			 res.sendRedirect("success.jsp");
		 }
		 else {
			 res.sendRedirect("error.html");
		 }
	 }
}
