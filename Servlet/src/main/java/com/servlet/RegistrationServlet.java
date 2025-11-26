package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("studentId");
		String name = request.getParameter("studentName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		
		out.println("<h1>Student Registration Details</h1>");
		out.println("<hr>");
		out.println("Student Id: " + id + "<br>");
		out.println("Student Name: " + name + "<br>");
		out.println("Email: " + email + "<br>");
		out.println("Gender: " + gender + "<br>");
		out.println("Course: " + course + "<br>");
	}
}
