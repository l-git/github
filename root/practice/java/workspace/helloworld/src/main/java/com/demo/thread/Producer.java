package com.demo.thread;

public class Producer implements Runnable{

	Q q;
	public Producer(Q q){
		this.q=q;
		new Thread(this,"producer").start();
	}
	
	
	
	public void run(){
		int i=1;
		while(true){
			q.setN(i++);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
