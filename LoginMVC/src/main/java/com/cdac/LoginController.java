package com.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{
	@GetMapping("/login")
	public String setform()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam ("username") String username, @RequestParam ("password") String password, Model model)
	{
		if(username.equals("admin") && password.equals("12345"))
		{
			model.addAttribute("user", username);
			return "welcome";
		}
		else
		{
			model.addAttribute("error", "Invalid username or password");
			return "error";
		}
	}
	
	

}
