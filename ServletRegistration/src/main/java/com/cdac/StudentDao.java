package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao 
{
	public boolean saveStudent(Student s) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ashu@123");
		
		String query = "insert into stu(name, prn, email) values(?,?,?)";
		
		PreparedStatement pmt = con.prepareStatement(query);
		
		pmt.setString(1, s.getName());
		pmt.setString(2, s.getPrn());
		pmt.setString(3, s.getEmail());
		
		int row = pmt.executeUpdate();
		
		boolean status = false;
		if(row > 0)
		{
			status = true;
		}
		return status;
		
	}

	
}
