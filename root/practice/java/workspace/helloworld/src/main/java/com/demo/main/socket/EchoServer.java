package com.demo.main.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	
	public static void main(String args[]){
		
		
		try {
			ServerSocket serverSocket=new ServerSocket(12345);
			
			
			Socket socket=serverSocket.accept();
			
			
			
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			
			
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
			
			
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
			
			String line;
			
			while((line=bufferedReader.readLine())!=null){
				
				System.out.println(line);
				
				printWriter.println(line);
				
				if(line.equals("bye")){
					break;
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
