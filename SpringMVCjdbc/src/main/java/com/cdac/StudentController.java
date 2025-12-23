package com.cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController 
{
	@Autowired
	public StudentDAO dao;
	
	@GetMapping("/register")
	public String getForm()
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String saveStudent(Student student, Model model)
	{
		int rows = dao.saveStudent(student);
		if(rows > 0)
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
}
