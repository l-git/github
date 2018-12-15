package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	private Object proxied;
	
	
	public MyInvocationHandler(Object proxied){
		this.proxied=proxied;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		
		System.out.println("before");
		Object o=method.invoke(proxied, args);
		System.out.println("after");
		
		
		return o;
	}

}
