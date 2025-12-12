package com.cdac;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class viewCartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		List<String> cart = (List<String>) session.getAttribute("cart");
		req.setAttribute("cartItems", cart);
		
		RequestDispatcher rd = req.getRequestDispatcher("viewCart.jsp");
		rd.forward(req, res);
	}
}
