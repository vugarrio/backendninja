package es.ugarrio.backendninja.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.ugarrio.backendninja.curso.entity.Course;
import es.ugarrio.backendninja.curso.repository.CourseJpaRepository;
import es.ugarrio.backendninja.curso.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl  implements CourseService{
	
	@Autowired                           //Inyectamos un componente
	@Qualifier("courseJpaRepository")    //Identificamos el componente por su nombre
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		return courseJpaRepository.save(course);		
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
