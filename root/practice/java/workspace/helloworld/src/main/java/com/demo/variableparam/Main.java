package com.demo.variableparam;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		m("1");
		
		
		
		
		m("a","b");
		
	}
	
	
	static void m(String ...args){
		
		for(String s:args){
			System.out.print(s);
		}
		
		System.out.println();
		
		
	}

}
