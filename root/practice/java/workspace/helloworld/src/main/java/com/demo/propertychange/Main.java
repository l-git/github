package com.demo.propertychange;

public class Main {

	public static void main(String args[]){
		
		
		
		MyBean m=new MyBean();
		
		
		
		
		m.addPropertyChangeListener(new MyPropertyChangeListener());
		
		
		
		
		
		m.setS1("111");
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
