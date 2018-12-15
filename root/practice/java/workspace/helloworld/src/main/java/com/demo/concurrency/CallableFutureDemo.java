package com.demo.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		class C implements Callable<String>{

			public String call() throws Exception {
				// TODO Auto-generated method stub
				String s="";
				for(int i=0;i<9;i++){
					s+=i;
				}
				
				return s;
			}
			
			
			
		}
		
		
		ExecutorService es=Executors.newCachedThreadPool();
		
		Future<String> f=es.submit(new C());
		
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
