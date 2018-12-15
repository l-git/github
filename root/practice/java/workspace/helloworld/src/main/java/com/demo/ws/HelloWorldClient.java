package com.demo.ws;

import com.demo.ws.HelloWorld;
import com.demo.ws.HelloWorldImplService;

public class HelloWorldClient{

	public static void main(String[] args) {

		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();

		System.out.println(hello.getHelloWorldAsString("mkyong111111111111111"));

    }

}
