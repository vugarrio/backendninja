package es.ugarrio.backendninja.curso.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.ugarrio.backendninja.curso.entity.Course;
import es.ugarrio.backendninja.curso.service.impl.CourseServiceImpl;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	//Creacion de Log. Al principio lo haremos con la libreria de apache, pero luego cambiaremos.
	private static final Log LOG = LogFactory.getLog(CourseController.class);
		
	
	//Inyectamos el servicio courseServiceImpl
	@Autowired
	@Qualifier("courseServiceImpl")
	CourseServiceImpl courseServiceImpl;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		
		LOG.info("Call METHOD: 'listAllCourses' ");
		
		ModelAndView mav = new ModelAndView(COURSES_VIEW);		
		mav.addObject("courses", courseServiceImpl.listAllCourses());	
		
		//Datos de un Course vacio para el formulario.
		mav.addObject("course", new Course());	
		
		LOG.info("TEMPLATE: '" + COURSES_VIEW  + "'  -- DATA: courseServiceImpl.listAllCourses() ");
		
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourses(@ModelAttribute("course") Course course ) { 
		LOG.info("Call METHOD: 'addCourses' -- PARAMS: '" + course.toString()  + "'");
		
		courseServiceImpl.addCourse(course);
		return "redirect:/courses/listcourses";		
	}	
}
