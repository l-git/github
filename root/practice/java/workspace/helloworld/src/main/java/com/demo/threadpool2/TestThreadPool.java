package com.demo.threadpool2;

public class TestThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ThreadPool pool=new ThreadPool(3);
		
		for(int i=0;i<5;i++){
			pool.assign(new WorkThread());
		}
		
		
		
		
		
	}

}
