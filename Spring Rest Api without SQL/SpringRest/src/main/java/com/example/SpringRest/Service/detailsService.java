package com.example.SpringRest.Service;

import java.util.List;

import com.example.SpringRest.models.Course;

public interface detailsService {

	List<Course>CourseList();
	Course getCourse(long id);
	Course addCourse(Course course);
}
