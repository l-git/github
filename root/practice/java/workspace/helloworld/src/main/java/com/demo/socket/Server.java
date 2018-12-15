package com.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			ServerSocket ss=new ServerSocket(7000);
			
			
			
			System.out.println("start");
			
			Socket socket=ss.accept();
			
			
			
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			int i;
			while((i=is.read())!=-1){
				System.out.println("receive:");
				System.out.println(i);
				os.write(++i);
				
			}
			
			
			is.close();
			os.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
