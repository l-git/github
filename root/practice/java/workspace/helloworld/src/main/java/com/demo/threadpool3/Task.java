package com.demo.threadpool3;

public class Task implements Runnable{

private ThreadPool threadPool;
	
	private static int counter;
	
	private int n;
	
	public Task(ThreadPool threadPool){
		this.threadPool=threadPool;
		
		counter++;
		n=counter;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		for(int i=10;i<13;i++){
			System.out.println(n+"\t:\t"+i);
		}
		
		
	}

}
