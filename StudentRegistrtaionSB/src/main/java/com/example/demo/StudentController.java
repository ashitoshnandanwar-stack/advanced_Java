package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController 
{
	@Autowired
	private StudentDAO dao;
	
	@GetMapping("/register")
	public String getForm(Model model)
	{
		model.addAttribute("student", new Student());
		return "register";
	}
	
	@PostMapping("/register")
	public String addStudent(@ModelAttribute Student student, Model model)
	{
		int rows = dao.insert(student);
		if(rows > 0)
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	
	@GetMapping("/view")
	public String viewStudents(Model model)
	{
		List<Student> list = dao.viewAll();
		model.addAttribute("students", list);
		return "view";
	}
}
