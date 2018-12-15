package com.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	
	Object object;
	
	public MyInvocationHandler(Object object){
		this.object=object;
	} 
	
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		
		/*Class<?> c=proxy.getClass();
		
		Obj ooo=(Obj) c.newInstance();*/
		
		System.out.println("before");
		
		Object o;
		
		o=method.invoke(object, args);
		
		System.out.println("after");
		
		return o;
	}

}
