package com.demo.event;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TestBean {


	private PropertyChangeSupport propertyChangeSurport =new PropertyChangeSupport(this);
	
	
	
	private String id;
	

	private String name;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		
		
		PropertyChangeEvent evt=new PropertyChangeEvent("source","propertyName","old","new");
		propertyChangeSurport.firePropertyChange(evt);
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		
		propertyChangeSurport.addPropertyChangeListener(listener);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
