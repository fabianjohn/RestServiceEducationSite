package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServices {
	@Autowired
	CourseRepository courseRepo;
	
	public List<Course> listAll()
	{
		return courseRepo.findAll();
	}
	public void save(Course course)
	{
		courseRepo.save(course);
	}

	public Course get(long id)
	{
		return courseRepo.findById(id).get();
	}
	public void delete(long id)
	{
		courseRepo.deleteById(id);
	}
	public Course findById(long id)
	{
		return courseRepo.findById(id).get();
	}
	public void saved(Course course)
	{
		courseRepo.save(course);
	}

}
