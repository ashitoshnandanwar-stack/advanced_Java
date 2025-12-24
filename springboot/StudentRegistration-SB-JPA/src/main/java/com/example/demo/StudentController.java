package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController 
{
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/register")
	public String getForm(Model model)
	{
		model.addAttribute("student", new Student());
		return "register";
	}
	
	@PostMapping("/register")
	public String addStudent(Student student, Model model)
	{
		studentRepository.save(student);
		
		model.addAttribute("students", studentRepository.findAll());
		return"view";
	}
	
	
}
