package com.demo.concurrency;

public class Main {

	public static void main(String args[]){
		
		
		T tt=new T();
		tt.canRun=true;
		Thread t=new Thread(tt);
		
		t.start();
		
		//tt.canRun=false;
		
		int n=0;
		while(true){
		System.out.println("main");
		try {
			
			Thread.sleep(1000);
			n++;
			if(n==3){
				tt.canRun=false;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
		
		
	}
	
	
	static class T implements Runnable{

		
		public boolean canRun;
		
		
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(canRun){
				System.out.println("can run");
			}
			
			System.out.print("can run over");
			
			
		}
		
		
		
	}
	
	
	
}
