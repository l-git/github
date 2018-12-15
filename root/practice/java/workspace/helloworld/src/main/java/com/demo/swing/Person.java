package com.demo.swing;

public class Person {

	private String id;
	
	private String name;
	
	
	
	private Boolean smoke;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Boolean getSmoke() {
		return smoke;
	}



	public void setSmoke(Boolean smoke) {
		this.smoke = smoke;
	}



	public Person(String id, String name, Boolean smoke) {
		super();
		this.id = id;
		this.name = name;
		this.smoke = smoke;
	}



	public Person() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
}
