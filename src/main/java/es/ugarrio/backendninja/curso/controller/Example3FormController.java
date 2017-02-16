package es.ugarrio.backendninja.curso.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.ugarrio.backendninja.curso.model.Person;

@Controller 
@RequestMapping("example3") 
public class Example3FormController {
	
	//Creacion de Log. Al principio lo haremos con la libreria de apache, pero luego cambiaremos.
	private static final Log LOG = LogFactory.getLog(Example3FormController.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	//Forma 1 de redireccionamiento
	/*@GetMapping("/")
	public String redirect () {
		return "redirect:/example3/showform";
	}*/
	
	//Forma 2 de redireccionamiento
	@GetMapping("/")
	public RedirectView redirect () {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")	//Devuelve la plantilla del formulario
	public String showForm (Model model) {
		//LOGGER.info("INFO TRACE");
		//LOGGER.warn("WARNING TRACE");
		//LOGGER.error("ERROR TRACE");
		//LOGGER.debug("DEBUG TRACE"); //Esta solo se muestra con el servidor en modo debug
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	//Obtiene los datos del formulario
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		
		LOG.info("METHOD: 'addPerson' -- PARAMS: '" + person.toString()  + "'");
		
		ModelAndView mav = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			// Si hay errores, retornamos al formualrio.
			mav.setViewName(FORM_VIEW);
			LOG.info("TEMPLATE: '" + FORM_VIEW  + "'  -- DATA: bindingResult '" + bindingResult.toString() + "'");			
			
		} else {
			// Si no hay errores vamos a la plantilla de la vista de persona.
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
			LOG.info("TEMPLATE: '" + RESULT_VIEW  + "'  -- DATA: '" + person + "'");	
		}
		
		
		
		return mav;
	}

}
