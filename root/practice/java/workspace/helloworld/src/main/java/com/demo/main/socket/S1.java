package com.demo.main.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class S1 {

	public static void main(String args[]){
		
		
		try {
			
			
			System.out.println("server");
			
			ServerSocket s=new ServerSocket(12345);
			
			Socket socket=s.accept();
			
			
			
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			
			
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
			String line;
			while((line=bufferedReader.readLine())!=null){
				
				printWriter.println("response:"+line);
				
				System.out.println(line);
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
