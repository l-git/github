package com.demo.impl;

import javax.jws.WebService;

import com.demo.SecondService;


@WebService
public class SecondServiceImpl implements SecondService{
	
	
	

	public String f(String s1, String s2) {
		// TODO Auto-generated method stub
		
		String r=s1+":"+s2;
		return r;
	}

}
