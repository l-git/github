package com.demo.jvm.oom;

import org.junit.Test;

public class MultithreadOOM {

	
	private static class SimpleThread implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			
		}

		
		
		
	}
	
	@Test
	public void t1(){
		
		for(int i=0;i<15000000;i++){
			
			new Thread(new SimpleThread(),"tread "+i).start();
			
			System.out.println("thread "+i+" created");
			
			
		}
		
		
		/*Cglibbean c;*/
		
		
	}
	
	
}
