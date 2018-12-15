package com.demo.main;

public class StackOverflowMain{

public static void main(String args[]){
	
	int n=0;
	try{
		n=m(1);
	
	}catch(Exception e){
			e.printStackTrace();
			//System.out.println(n);
	}
	
	
}


static int m(int n){
	
	Long l1;
	Long l2;
	Long l3;
	Long l4;
	Long l5;
	System.out.println(n);
	
	return m(++n);
	
	
}





}
