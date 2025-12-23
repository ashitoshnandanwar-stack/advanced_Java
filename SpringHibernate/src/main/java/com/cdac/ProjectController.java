package com.cdac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cdac.Project;
import com.cdac.ProjectDAO;


@Controller
public class ProjectController 
{
	@Autowired
	private ProjectDAO dao;
	
	@GetMapping("/register")
	public String getForm()
	{
		return"register";
	}
	
	@PostMapping("/register")
	public String registerProject(@ModelAttribute Project project)
	{
		dao.saveProject(project);
		return "redirect:/viewProject";
	}
	
	@GetMapping("/viewProject")
	public String viewProject(Model model)
	{
		List<Project> list = dao.viewAllProject();
		model.addAttribute("projects", list);
		return "viewProject";
	}
	
	
	
}
