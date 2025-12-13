package com.cdac;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
		String pass = req.getParameter("pass");
		
		Session session = HibernateUtil.getSession();
		Query<User> q = session.createQuery("from User where username = :u and password = :p", User.class);
		q.setParameter("u", uname );
		q.setParameter("p", pass);
		User user = q.uniqueResult();
		session.close();
		
		if(user != null)
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("username", uname);
			
			res.sendRedirect("shopping.html");
			
		}
		else
		{
			res.getWriter().println("Invalid login ....") ;
			res.getWriter().println("<a href='login.html'>Try again</a>");
		}
	}
}
