package com.demo.main.thread;

public class Consumer implements Runnable{

	
	Q q;
	public Consumer(Q q){
		this.q=q;
		new Thread(this,"consumer").start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			q.get();
		}
	}

}
