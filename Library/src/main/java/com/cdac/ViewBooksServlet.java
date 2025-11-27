package com.cdac;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewBooksServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		List<String[]> bookList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_db", "root", "cdacacts");
			
			Statement st = con.createStatement();
			String query = "select * from books";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) 
			{
				String[] book = 
					{
						rs.getString(1), rs.getString(2), rs.getString(3), String.valueOf(rs.getInt(4))
				};
				bookList.add(book);
			}
			
			req.setAttribute("bookList", bookList);
			RequestDispatcher rd = req.getRequestDispatcher("viewBooks.jsp");
			rd.forward(req, res);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
