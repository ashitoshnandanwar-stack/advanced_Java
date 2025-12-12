package com.cdac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class addCartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String item = req.getParameter("item");
		
		HttpSession session = req.getSession();
		
		List<String> cart = (List<String>) session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new ArrayList<>();
		}
		
		cart.add(item);
		session.setAttribute("cart", cart);
		
		res.sendRedirect("shopping.html");
	}

}
