package com.example.SpringRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRest.Service.detailsService;
import com.example.SpringRest.models.Course;

@RestController
public class myController {

	@Autowired
	detailsService DetailsService;
	
	
	@GetMapping("/home")
	
	public String homePage() {
		return "This is a Home Page";
	}
	
	@GetMapping("/course")
	
	public List<Course>addCourse(){
		return DetailsService.CourseList();
	}
	
	
	@GetMapping("/course/{id}")
	
	public Course getCourse(@PathVariable("id") long id) {
		return DetailsService.getCourse(id);
	}
	
	
	@PostMapping("/course")
	
	public Course addCourse(@RequestBody Course course) {
		return (DetailsService.addCourse(course));
		
	}
}
