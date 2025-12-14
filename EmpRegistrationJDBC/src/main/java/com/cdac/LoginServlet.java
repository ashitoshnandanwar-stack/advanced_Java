package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		res.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean valid = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac","root","Ashu@123");
			
			String query = "select * from users where username = ? and password = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				valid = true;
			}
			
			if(valid)
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				res.sendRedirect("register.html");
			}
			else {
				res.getWriter().println("Invalid login");
				res.getWriter().println("<a href='login.html'>Try again</a>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
