package com.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.URL;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Obj obj=new ObjImpl();
		
		InvocationHandler h=new MyInvocationHandler(obj);

		obj=(Obj) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), h);
		
		System.out.println(obj.m());
		
		
		Class<?> c=obj.getClass();
		
		
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		
		
		System.out.println(System.getProperty("java.class.path"));
		
		//cl.getResources("/");
		URL url=cl.getResource("");
		
		System.out.println(url);
		
		
		
		
		
		
		
		
		
	}

}
