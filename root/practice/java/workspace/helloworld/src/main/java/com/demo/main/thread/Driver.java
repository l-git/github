package com.demo.main.thread;

public class Driver {

	
	public static void main(String args[]){
		
		
		Q q=new Q();
		
		Procedure p=new Procedure(q);
		
		Consumer c=new Consumer(q);
		
		
		
		
	}
	
	
	
}
