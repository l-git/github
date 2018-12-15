package com.demo.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		class C implements Callable<Object>{

			public Object call() throws Exception {
				// TODO Auto-generated method stub
				
				Integer sum=0;
				for(int i=0;i<10;i++){
					System.out.println("i="+i);
					sum+=i;
				}
				
				
				return sum;
			}
			
			
			
		}
		
		C c=new C();
		
		FutureTask ft=new FutureTask(c);
		
		new Thread(ft).start();
		
		
		try {
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("fefef");
		
		
		
		
	}

}
