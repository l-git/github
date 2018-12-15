package com.demo.thread;

public class Q {

	int n;
	
	boolean b;
	public synchronized void setN(int n){
		
		while(b){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		this.n=n;
		System.out.println("set "+n);
		b=true;
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public synchronized int getN(){
		
		while(!b){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("get "+n);
		b=false;
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.n;
	}
	
	
}
