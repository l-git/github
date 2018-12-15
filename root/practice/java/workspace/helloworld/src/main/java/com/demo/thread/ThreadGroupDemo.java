package com.demo.thread;

public class ThreadGroupDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ThreadGroup tg=Thread.currentThread().getThreadGroup();
		System.out.println(tg);
		
		Thread t1=new Thread(tg,"nam31");
		
		t1.start();
		
		tg.activeCount();
		
		tg.list();
		

	}

}
