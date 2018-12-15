package com.demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	
	public static void main(String args[]){
		
		
		
		class R implements Runnable{

			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println("R");
				
			}
			
			
		}
		
		
		
		ExecutorService es=Executors.newSingleThreadExecutor();
		
		es.execute(new R());
		
		
		es.shutdown();
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
