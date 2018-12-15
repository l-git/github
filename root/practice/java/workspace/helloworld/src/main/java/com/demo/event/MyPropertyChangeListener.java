package com.demo.event;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyPropertyChangeListener implements PropertyChangeListener{

	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		System.out.println(evt.getPropertyName());
		
		
	}

}
