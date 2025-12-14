package com.cdac;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao 
{
	

	public static Connection getConnection() throws Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac","root","Ashu@123");
		return con;
		
	}
	public int insertEmp(Employee e) throws Exception 
	{
		Connection con = EmpDao.getConnection();
		
		String query = "insert into employee(name, email, course) values (?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.setString(3, e.getCourse());
		
		int status = ps.executeUpdate();
		
		return status;
		
		
	}
	public List<Employee> viewEmp() throws Exception 
	{
		List<Employee> list = new ArrayList<>();
		Connection con = EmpDao.getConnection();
		
		String query = "select * from employee";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setCourse(rs.getString(4));
			
			list.add(e);
			
		}
		return list;
		
		
	}

}
