package com.democlient;

import com.demoserver.HelloServiceImpl;
import com.demoserver.HelloServiceImplService;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HelloServiceImpl a=new HelloServiceImplService().getHelloServiceImplPort();
		
	
		String r=a.f("dfffffffffffff ");
		System.out.println(r);
	}

}
