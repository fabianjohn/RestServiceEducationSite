package com.example.demo.users;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	
	
	@GetMapping("/")
	public String homePage() {
		return "home";
		
	}
	
	@GetMapping("/register")
		public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register_form";
	}
	
	@PostMapping("/process_register")
	public String viewRegisterSuccess(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
			
		repo.save(user);
		return "register_success";
	}
	
	
	/*
	@GetMapping("/list_user")
	public String viewUsers(Model model) {
		List<User>listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "user_profile";
			
	}
	/*
	@GetMapping("/list_user")
	public String userProfile() {
		
		return "user_profile";
	}
	*/
	
	
}
