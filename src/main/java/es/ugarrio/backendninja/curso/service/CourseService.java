package es.ugarrio.backendninja.curso.service;

import java.util.List;

import es.ugarrio.backendninja.curso.entity.Course;

public interface CourseService {
	
	public abstract List<Course> listAllCourses();
	public abstract Course addCourse(Course course);
	public abstract int removeCourse (int id);
	public abstract Course updateCourse (Course course);
	
}
