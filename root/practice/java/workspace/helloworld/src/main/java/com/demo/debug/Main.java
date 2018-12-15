package com.demo.debug;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Main {

	private static final Logger logger=Logger.getLogger(Main.class);
	
	private String ss;
	
	
	
	public String getSs() {
		return ss;
	}



	public void setSs(String ss) {
		this.ss = ss;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//logger.debug("message");
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("a", "b");
		
		map.get("c");
		
		Main m=new Main();
		m.ss="a";
		
		logger.debug("..");
		
		
		
	}

	
	public void m(){
		
		System.out.println("m");
		
	}
	
	
}
