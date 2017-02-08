package es.ugarrio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ugarrio.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	//Lo suyo es declarar estas constantes en un fichero dentro de un paquete contantes
	public static final String EXAMPLE_VIEW = "example";
	
	//Primera forma
	@GetMapping("exampleString") //Nueva version 4.3 Sustituye a la linea de abajo
	//@RequestMapping(value="exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		
		model.addAttribute("people", this.getPeople());
		
		return EXAMPLE_VIEW;
		
		// Esta forma se suele usar para redirecciones o se tienen que insertar
		// pocos datos en la plantilla 
	}
	
	//Segunda forma
	@RequestMapping(value="exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", this.getPeople());
		
		
		return mav;
		
		//Esta forma se usa cuando se tienen que insertar muchos datos en la plantilla
	}
	
	
	private List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Vicente 1 MAV", 41));
		people.add(new Person("Vicente 2 MAV", 43));
		people.add(new Person("Vicente 3 MAV", 51));
		people.add(new Person("Vicente 3 MAV", 61));
		people.add(new Person("Vicente 5 MAV", 71));
		
		return people;
	}
}
