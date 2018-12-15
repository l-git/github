package com.demo.concurrency;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ThreadUnsafe {

	
	/*static List<String> list=new ArrayList<String>();*/
	
	private static class T1 implements Runnable{

		
		List<String> list;
		
		public T1(List<String> list){
			this.list=list;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		
			for(int i=0;i<11000000;i++){
				System.out.println(Thread.currentThread().getName()+":"+i);
				list.add(""+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("list size:"+list.size());
			
		}
		
		
		
		
		
		
	}
	
	/*@Test*/
	public static void main(String args[]){
		List<String> list=new ArrayList<String>();
		
		new Thread(new T1(list)).start();
		new Thread(new T1(list)).start();//new Thread(new T1()).start();new Thread(new T1()).start();
		
		
	}

	
	
}
