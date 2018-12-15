package com.demo.main.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.domain.Hello;

public class Main {

	public static void main(String args[]){
		
		
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Hello hello=(Hello) applicationContext.getBean("hello");
		
		System.out.print(hello.getName());
		
		
	}
	
	
}
