package com.demo;

import javax.xml.ws.Endpoint;

import com.demo.impl.HelloServiceImpl;
import com.demo.impl.SecondServiceImpl;

public class PublishService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HelloService helloService=new HelloServiceImpl();
		
		
		
		
		Endpoint.publish("http://localhost:9001/service/helloService", helloService);

		SecondService secondService=new SecondServiceImpl();
		Endpoint.publish("http://localhost:9001/service/secondService", secondService);
		
		
		System.out.println("public success");
		
		
	}

}



