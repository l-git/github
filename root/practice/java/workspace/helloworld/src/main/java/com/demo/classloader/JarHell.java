package com.demo.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class JarHell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Enumeration<URL> urls;
		try {
			urls = ClassLoader.getSystemResources("META-INF/MANIFEST.MF");
			
			
			
			
			while(urls.hasMoreElements()){
				
				System.out.println(urls.nextElement());
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
