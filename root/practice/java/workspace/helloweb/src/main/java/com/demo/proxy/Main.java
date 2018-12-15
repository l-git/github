package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyProxyInterface myProxyInterface=new MyProxyInterfaceImpl();
		
		
		InvocationHandler invocationHandler=new MyInvocationHandler(myProxyInterface);

		//myProxyInterface=invocationHandler.invoke(myProxyInterface.getClass().getClassLoader(),myProxyInterface.getClass().getMethods() , null);
		
		myProxyInterface=(MyProxyInterface) Proxy.newProxyInstance(myProxyInterface.getClass().getClassLoader(), myProxyInterface.getClass().getInterfaces(), invocationHandler);
		
		
		myProxyInterface.m();
		
		
		
	}

}
