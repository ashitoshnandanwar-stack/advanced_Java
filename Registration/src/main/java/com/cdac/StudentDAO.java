package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO 
{
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dac","root", "cdacacts");
		return con;
	}
	

	public int writeStudent(Student s) throws Exception
	{
		Connection con = StudentDAO.getConnection();
		String query = "insert into students (name, email, course) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, s.getName());
		ps.setString(2, s.getEmail());
		ps.setString(3, s.getCourse());
		
		int status = ps.executeUpdate();
		return status;
	}


	public List<Student> getAllStudents() throws Exception 
	{
		List<Student> list = new ArrayList<>();

		
		Connection con =StudentDAO.getConnection();
		 String q = "select * from students";
		 
		 PreparedStatement ps = con.prepareStatement(q);
         ResultSet rs = ps.executeQuery();
		
         while (rs.next()) {
             Student s = new Student();
             s.setId(rs.getInt(1));
             s.setName(rs.getString(2));
             s.setEmail(rs.getString(3));
             s.setCourse(rs.getString(4));
             
             list.add(s);
         }

		return list;
         
         
		
	}
	

	
}
