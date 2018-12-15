package com.demo.main;

import java.net.URL;

public class URLJar {

	
	public static void main(String ags[]){
		
		URLJar u=new URLJar();
		System.out.println(u.getU());
		
		
	}
	
	
	URL getU(){
		URL url=this.getClass().getResource("/");
		
		return url;
	}
	
}
