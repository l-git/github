package com.demo.threadpool2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ThreadPool {

	protected Thread threads[];
	
	private Collection<Runnable> assignment=new ArrayList<Runnable>();
	
	
	public ThreadPool(int size){
		
		threads=new Thread[size];
		
		
		for(int i=0;i<threads.length;i++){
			threads[i]=new WorkerThread(this);
			threads[i].start();
		}
		
		
		
		
	}
	
	
	public synchronized void assign(Runnable r){
		
		
		assignment.add(r);
		notify();
		
		
	}
	
	
	
	synchronized public Runnable getAssignment(){
	
		
		while(!assignment.iterator().hasNext()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		Runnable r=(Runnable) assignment.iterator().next();
		assignment.remove(r);
		
		
		return r;
		
		
		
	}
	
	

}


class WorkerThread extends Thread{
	
	private ThreadPool threadPool;
	
	public WorkerThread(ThreadPool threadPool){
		
		
		this.threadPool=threadPool;
		
		
	}
	
	public void run(){
		
		
		Runnable r=null;
		
		
		
		do{
			r=threadPool.getAssignment();
			if(r!=null){
					r.run();
			}
		}while(r!=null);
		
	}
}
