package es.ugarrio.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue()
	@Column(name="id", unique=true, nullable=false)
	private int id;
	
	@Column(name="name", length=150)
	private String name;
	
	@Column(name="description", length=300)
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="hours")
	private int hours;
	

	public Course() {
	}
	
	


	public Course(int id, String name, String description, int price, int hours) {
		super();
		this.description = description;
		this.hours = hours;
		this.id = id;
		this.name = name;
		this.price = price;
	}




	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getHours() {
		return this.hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}


	public int getIdCurso() {
		return this.id;
	}

	public void setIdCurso(int id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", hours="
				+ hours + "]";
	}
	
	

}