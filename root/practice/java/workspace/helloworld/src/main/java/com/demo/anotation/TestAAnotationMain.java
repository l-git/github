package com.demo.anotation;

import java.lang.annotation.Annotation;

public class TestAAnotationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		m1();
		
		System.out.println("..");
		
		/*Class<?> c=ClassWithAAnotation.class;
		
		
		if(c.isAnnotationPresent(AAnotation.class)){
			
			AAnotation a=c.getAnnotation(AAnotation.class);
			System.out.println(a.name());
			System.out.println(1);
		}else{
			System.out.println(0);
		}*/
		
		
		
		
	}
	
	static void m1(){
		System.out.println(".1.");
	
		m();
		
		System.out.println(".2.");
	}

	static void m(){
		int i=1;
		int z=0;
		int r=i/z;
	}
	
}
