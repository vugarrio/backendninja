package es.ugarrio.backendninja.curso.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import es.ugarrio.backendninja.curso.controller.Example3FormController;

@Component("ExampleComponent")   //Le indicamos a Spring que esta clase es un componente y que lo guarde en memoria
public class ExampleComponent {
	
	//Creacion de Log. Al principio lo haremos con la libreria de apache, pero luego cambiaremos.
	private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
		
	
	public void sayHello() {
		
		LOGGER.info("METHOD: 'sayHello'");
		
		
	}
}
