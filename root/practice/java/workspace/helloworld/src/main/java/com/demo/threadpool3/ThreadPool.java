package com.demo.threadpool3;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

	
	private Thread threads[];
	
	private List<Runnable> list=new ArrayList<Runnable>();
	
	public ThreadPool(int poolSize){
		
		threads=new WorkerThread[poolSize];
		
		
		for(Thread t:threads){
			
			t=new WorkerThread(this);
			t.start();
			
		}
		
		
	}
	
	
	synchronized Runnable get(){
		
		while(!list.iterator().hasNext()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Runnable r=list.iterator().next();
		list.remove(r);
		return r;
		
		
	}
	
	
	synchronized void put(Runnable r){
		
		
		list.add(r);
		
		notify();
		
		
	}
	
	
	
	
	
	
}


class WorkerThread extends Thread{

	private ThreadPool threadPool;
	
	private static int counter;
	
	private int n;
	
	public WorkerThread(ThreadPool threadPool){
		this.threadPool=threadPool;
		
		counter++;
		n=counter;
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		
		Runnable r;
		
		do{
		r=threadPool.get();
		
		r.run();
		}while(r!=null);
		
		
		
	}
	
	
	
}
