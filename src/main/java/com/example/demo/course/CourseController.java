package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.users.User;



@Controller
@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	CourseServices service;
	
	@Autowired
	CourseRepository courseRepo;
	
	@GetMapping
	public List<Course> getAllCourse(){
		return this.courseRepo.findAll();
	}
	
	@GetMapping("/list_user")
	public String viewHomePage(Model model)
	{
		List<Course>listcourses = service.listAll();
		model.addAttribute("listcourses", listcourses);
		System.out.print("Get / ");
		return "user_profile";
	}
	
	
	@GetMapping("/course")
	public String add(Model model) {
		model.addAttribute("course", new Course());
		return "course_register";
	}
	
	@PostMapping("/save")
	public String saveCourse(Course course) {
		courseRepo.save(course);
		return "register_success";
	}
	
	
	/*
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course)
	{
		service.save(course);
		return"register_success";
	}
	*/
	
	@RequestMapping("/edit/{id}")
	public ModelAndView userProfile(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("course_register");
		Course course = service.get(id);
		mav.addObject("course", course);
		return mav;
		
		
	}
	
}
