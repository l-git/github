package com.demo.main;

public class MultiThreadOOM {

	
	static class SimpleThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
	}
	
	
	public static void main(String args[]){
		
		
		
		for(int i=0;i<150000;i++){
			
			new Thread(new SimpleThread(),"thread"+i).start();
			
			//CglibBean cb;
			
		}
		
		
		
		
	}
	
	
	
}
