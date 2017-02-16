package es.ugarrio.backendninja.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	public static final String HOME_VIEW = "home";
	
	@GetMapping("/")
	public String home() {		
		return HOME_VIEW;
	}
	
	
}
