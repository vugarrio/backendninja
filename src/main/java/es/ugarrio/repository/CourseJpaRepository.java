package es.ugarrio.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;


import es.ugarrio.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {
	
	// Aparte de las multiples funcines que nos aporta JpaRepository, podemos
	// declarar otras con una estructura definida por JPA, ejemplos:
	
	
	public abstract Course findByPrice(int price);
	
	public abstract Course findByPriceAndName(int price, String name);
	
	public abstract List<Course> findByNameOrderByHours(String name);
	
	public abstract Course findByNameOrPrice (String name, int price);
	
}
