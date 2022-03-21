package com.example.SpringRest.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringRest.models.Course;

@Service
public class detailsServiceImpl implements detailsService {

	List<Course>list;
	
	  public detailsServiceImpl() {
		list =  new ArrayList<>();
		list.add(new Course(506,"Numan","CSE"));
		list.add(new Course(516,"Jakaria","CSE"));
	}
	
	@Override
	public List<Course> CourseList() {
		
		return list;
	}

	@Override
	public Course getCourse(long id) {
		Course c = null;
		for(Course course:list) {
			if(course.getId()==id) {
				c = course;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
		
	}
	
	

	
}
