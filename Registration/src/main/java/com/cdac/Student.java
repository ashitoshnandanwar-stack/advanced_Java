package com.cdac;

public class Student 
{
	int id;
	String name;
	String email;
	String course;
	public Student(String name, String email, String course) 
	{
		
		this.name = name;
		this.email = email;
		this.course = course;
	}
	
	public Student() {
	
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getCourse() {
		return course;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
}
