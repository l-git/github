package com.demo.main;

import java.io.File;
import java.io.IOException;

import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.SystemPropertyUtils;

public class Md5Main {

	public static void main(String args[]){
		
		String hello="abc";
		
		
		System.out.println(System.getProperty("java.compiler"));
		/*File in=new File("e:/a/bcg.png");
		File out=new File("e:/a/bcg1.png");
		try {
			FileCopyUtils.copy(in, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File src=new File("e:/a/img");
		File dest=new File("e:/a/img1");
		try {
			FileSystemUtils.copyRecursively(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.library.path"));
		
		System.out.println(System.getProperty("java.class.path"));
		
		File directory = new File (".");
		 try {
		 System.out.println ("Current directory's canonical path: " 
		  + directory.getCanonicalPath()); 
		   System.out.println ("Current directory's absolute  path: " 
		  + directory.getAbsolutePath());
		 }catch(Exception e) {
		 System.out.println("Exceptione is ="+e.getMessage());
		  }
		*/
		
		
		
		
		
	}
	
}
