package com.demo.main.thread;

public class Q {

	int i;
	boolean b;
	public synchronized void put(int i){
		
		
		while(b){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b=true;
		notify();
		
		System.out.println("put "+i);
		this.i=i;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public synchronized int get(){
		
		
		while(!b){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		b=false;
		
		System.out.println("get "+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
		return i;
	}
	
	
	
	
	
	
}
