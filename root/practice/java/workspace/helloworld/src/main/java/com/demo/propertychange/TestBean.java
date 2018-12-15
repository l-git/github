package com.demo.propertychange;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TestBean {
	
	
	
	
	
	private PropertyChangeSupport propertyChangeSupport =new PropertyChangeSupport(this);
	
	
	
	public void addPropertyChangeEvent(PropertyChangeListener propertyChangeListener){
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}
	
	

	private String p;

	public String getP() {
		return p;
	}

	public void setP(String p) {
		propertyChangeSupport.firePropertyChange("p", this.p, p);
		this.p = p;
	}
	
	
	
	
	
	
}
