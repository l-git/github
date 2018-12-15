package com.demo.impl;

import javax.jws.WebService;

import com.demo.HelloService;

@WebService
public class HelloServiceImpl implements HelloService{

	public String f1(String s) {
		// TODO Auto-generated method stub
		
		String a="f inn HelloServiceImpl 234";
		System.out.println(a);
		
		return a+s;
	}

}
