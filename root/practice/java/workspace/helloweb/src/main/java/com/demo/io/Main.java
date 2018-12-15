package com.demo.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try{
		
			
			OutputStream out=new FileOutputStream("aa.txt");
		
		DataOutputStream d=new DataOutputStream(out);
		
		while(true){
			int i=5555;
			d.writeInt(i);
			Thread.sleep(1000);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
