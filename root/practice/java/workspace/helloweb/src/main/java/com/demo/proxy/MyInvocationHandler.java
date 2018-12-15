package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	
	private Object object;
	
	public MyInvocationHandler(Object object){
		this.object=object;
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		
		System.out.println("before");
		
		proxy=method.invoke(object, args);
		
		System.out.println("after");
		
		
		
		return proxy;
	}

}
