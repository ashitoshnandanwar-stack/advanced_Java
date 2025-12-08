package com.cdac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewStudentServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		StudentDAO sd = new StudentDAO();
		List<Student> list = null;
		
		try {
			list = sd.getAllStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("studentlist", list);
		RequestDispatcher rd = req.getRequestDispatcher("viewstudents.jsp");
		rd.forward(req, res);
	}
}
