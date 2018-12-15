package com.demo.thread;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		final O o=new O();
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<5;i++){
					M m1=new M(o);
					m1.start();
					
					//System.out.println(o.getI());
					
				}
			}
			
			
		}).start();
		
		
		//System.out.println(o.getI());
		
		
		
		
	}

	
	static void a(){
		
		b();
	}
static void b(){
		
	c();
	}
	
static void c(){
	Thread.dumpStack();
	
}

	
	
}


class O{
	
	private int i;

	public synchronized int getI() {
		System.out.println(i);
		return i;
	}

	public synchronized void setI(int ii) {
		//this.i = i;
		
		//Thread.yield();
		
		System.out.println(Thread.currentThread().getName());
		Random r=new Random();
		int s=r.nextInt(3);
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.i = getI()+1;
		/*try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	
}


class M extends Thread{
	
	private O o;
	
	public M(O o){
		this.o=o;
	}
	
	/*@Override
	public void start(){
		for(int i=0;i<5;i++){
			
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//o.setI(100);
		}
	}*/
	
	@Override
	public void run(){
		
		o.setI(100);
	}
	
	
	
	
}

