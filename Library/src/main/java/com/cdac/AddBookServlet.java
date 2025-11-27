package com.cdac;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String title = req.getParameter("bookTitle");
		String author = req.getParameter("authorName");
		String genre = req.getParameter("genre");
		int year = Integer.parseInt(req.getParameter("year"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_db", "root", "cdacacts");
			
			String query = "Insert into books (title, author, genre, year) values (?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, genre);
			ps.setInt(4, year);
			
			ps.executeUpdate();
		
			
			
			RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
			rd.forward(req, res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
