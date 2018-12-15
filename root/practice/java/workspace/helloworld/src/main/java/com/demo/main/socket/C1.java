package com.demo.main.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class C1 {

	public static void main(String args[]){
		
	
		
		try {
			
			System.out.println("Client");
			
			Socket socket=new Socket("127.0.0.1",12345);
			
			
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			
			
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
			
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			String line;
			
			while((line=stdIn.readLine())!=null){
				printWriter.println(line);
				String s=bufferedReader.readLine();
				
				System.out.println(s);
				
				
				
				
				
			}
			
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
