package es.ugarrio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.ugarrio.model.Person;

@Controller 
@RequestMapping("example3") 
public class Examle3FormController {
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	@GetMapping("/showform")	//Devuelve la plantilla del formulario
	public String showForm (Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		return mav;
	}

}
