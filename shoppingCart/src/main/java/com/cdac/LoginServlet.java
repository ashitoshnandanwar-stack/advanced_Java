package com.cdac;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException

	{
		res.setContentType("text/html");
		
		String uname = req.getParameter("user");
		String password = req.getParameter("pass");
		
		if(uname.equals("ashitosh") && password.equals("12345"))
		{
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			
			res.sendRedirect("shopping.html");
			
		}
		else
		{
			res.getWriter().println("Invalid login ....") ;
			res.getWriter().println("<a href='login.html'>Try again</a>");
		}
	}
}
