package es.ugarrio.backendninja.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloWorldController {
	
	@GetMapping("/helloworld")   //Nueva etiqueta de Spring 4
	public String helloWorld () {
		return "helloworld";
	}
	
}
