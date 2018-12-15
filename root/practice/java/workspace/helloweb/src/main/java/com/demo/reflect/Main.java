package com.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Class<?> clazz=Main.class;
		
		
		try {
			Method m=clazz.getDeclaredMethod("m2", null);
			
			Main mObj=new Main();
			m.invoke(null, null);
			
			
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	void m1(){
		System.out.println("m1");
	}
	
	
	static void m2(){
		System.out.println("m2");
	}
}
