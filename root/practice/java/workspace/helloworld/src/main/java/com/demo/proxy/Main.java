package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		I i=new Im();
		
		
		InvocationHandler h=new MyInvocationHandler(i);
		
		I i1=(I) Proxy.newProxyInstance(i.getClass().getClassLoader(), i.getClass().getInterfaces(), h);
		
		i1.m();
		
	}

}
