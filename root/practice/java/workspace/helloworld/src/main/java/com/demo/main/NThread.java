package com.demo.main;

public class NThread extends Thread{

	
	@Override
	public void run(){
		
		Thread t=Thread.currentThread();
		
		for(int i=0;i<10;i++){
			System.out.println("i am thread "+ t.getName()+" i="+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String args[]){
		
		NThread t1=new NThread();
		NThread t2=new NThread();
		NThread t3=new NThread();
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(Thread.currentThread().getName());
		
	}
	
	
	
}
