package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController 
{
	@Autowired
	public StudentDAO dao;
	
	@GetMapping("/")
	public String loggedIn()
	{
		return"login";
	}
	
	@PostMapping("/login")
	public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password, Model model)
	{
		boolean valid = dao.check(username, password);
		
		if(valid)
		{
			return "register";
		}
		else
		{
			return "error";
		}
	}
	
	@GetMapping("/register")
	public String getForm()
	{
		return"register";
	}
	
	
	@PostMapping("/register")
	public String addStudent(Student student, Model model)
	{
		int rows = dao.insert(student);
		if(rows > 0)
		{
			return "success";
		}
		else
		{
			return "err";
		}
	}
	
	@GetMapping("/view")
	public String viewStudent(Model model)
	{
		List<Student> list = dao.view();
		model.addAttribute("studentList", list);
		return "studentList";
	}
	
}
