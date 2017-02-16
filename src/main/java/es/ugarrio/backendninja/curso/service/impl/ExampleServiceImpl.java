package es.ugarrio.backendninja.curso.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import es.ugarrio.backendninja.curso.model.Person;
import es.ugarrio.backendninja.curso.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	
	@Override
	public List<Person> getListPeople() {
		
		LOG.info("SERVICE --- METHOD: 'getListPeople'");
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Vicente 1 MAV", 41));
		people.add(new Person("Vicente 2 MAV", 43));
		people.add(new Person("Vicente 3 MAV", 51));
		people.add(new Person("Vicente 3 MAV", 61));
		people.add(new Person("Vicente 5 MAV", 71));
		
		
		return people;
	}

}
