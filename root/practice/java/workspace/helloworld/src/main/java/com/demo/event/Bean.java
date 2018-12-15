package com.demo.event;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;




public class Bean {
	
	
	
	
	private PropertyChangeSupport propertyChangeSupport=new PropertyChangeSupport(this);
	
	
	

	private String id;
	
	
	
	private String name;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		propertyChangeSupport.firePropertyChange("id", this.id, id);
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener event){
		propertyChangeSupport.addPropertyChangeListener(event);
	}
	
	
	
}
