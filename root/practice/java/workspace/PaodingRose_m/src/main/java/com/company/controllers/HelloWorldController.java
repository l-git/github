package com.company.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/*@Path("helloWorld")*/
public class HelloWorldController {

	
	@Get
	public Object index(){
		
		System.out.println(System.getProperty("java.class.path"));
		
		return "@"+"hello world!";
	}
	
}
