package com.demo.main.thread;

public class Procedure implements Runnable{

	Q q;
	
	public Procedure(Q q){
		this.q=q;
		new Thread(this,"procdure").start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i=1;
		while(true){
			q.put(i);
			i++;
		}
		
		
		
	}

}
