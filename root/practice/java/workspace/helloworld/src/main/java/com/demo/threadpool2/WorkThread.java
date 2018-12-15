package com.demo.threadpool2;

public class WorkThread implements Runnable{

	private int count;
	
	static private int n;
	
	public WorkThread(){
		n++;
		this.count=n;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<3;i++){
			String name=count+"==";
			System.out.println(name+"\t:\t"+i);
			
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
