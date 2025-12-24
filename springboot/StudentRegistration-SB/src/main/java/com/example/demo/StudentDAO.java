package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO 
{
	@Autowired
	DataSource datasource;
	
	public boolean check(String username, String password) 
	{
		
		try {
			Connection con = datasource.getConnection();
			
			String query = "select * from user where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			return rs.next();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	public int insert(Student student) 
	{
		try {
			Connection con = datasource.getConnection();
			String query = "insert into student (name, email, course) values (?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCourse());
			
			int rows = ps.executeUpdate();
			
			return rows;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}

	public List<Student> view() 
	{
		List<Student> list = new ArrayList<>();
		
		try {
			Connection con = datasource.getConnection();
			
			String query = "select * from student";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setCourse(rs.getString(4));
				
				list.add(s);
			}
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

}
