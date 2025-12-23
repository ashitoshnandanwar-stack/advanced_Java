package com.cdac;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	
	@Autowired
	DataSource datasource;
	public int saveStudent(Student student) 
	{
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			con = datasource.getConnection();
			
			String query = "insert into student (name, email, course) values (?,?,?)";
			ps = con.prepareStatement(query);
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

}
