package es.ugarrio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ugarrio.component.ExampleComponent;
import es.ugarrio.model.Person;
import es.ugarrio.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	//Lo suyo es declarar estas constantes en un fichero dentro de un paquete contantes
	public static final String EXAMPLE_VIEW = "example";
	
	
	//Inyectamos un componente
	@Autowired
	@Qualifier("exampleService")  //Injectamos el servicio.
	private ExampleService exampleService;
	
	
	//Inyectamos un componente
	@Autowired
	@Qualifier("ExampleComponent")  //Le indicamos que inyecte el componente ExampleComponent
	private ExampleComponent exampleComponent;
	
	
	
	//Primera forma
	@GetMapping("exampleString") //Nueva version 4.3 Sustituye a la linea de abajo
	//@RequestMapping(value="exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		
		exampleComponent.sayHello();
		
		model.addAttribute("people", exampleService.getListPeople());		
		return EXAMPLE_VIEW;
		
		// Esta forma se suele usar para redirecciones o se tienen que insertar
		// pocos datos en la plantilla 
	}
	
	//Segunda forma
	@RequestMapping(value="exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		
		
		return mav;
		
		//Esta forma se usa cuando se tienen que insertar muchos datos en la plantilla
	}
	
	
	
}
