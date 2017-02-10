package es.ugarrio.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   /* Esta etiqueta le indica a Spring que cuando se produzca un error venga ha este controlador*/
public class ErrorsController {
	
	public static final String ISE_VIEW = "error/500";
	
	@ExceptionHandler(Exception.class)   /* Indicamos que cuando se produce una excepcion venga aqui/ */
	public String showInternalServerError() {
		return ISE_VIEW;
	}
	
}
