package com.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket=new Socket("127.0.0.1",8090);
			
			OutputStream os=socket.getOutputStream();
			
			InputStream is=socket.getInputStream();
			
			
			for(int i=0;i<10;i++){
				
				os.write(i);
				
				System.out.println(is.read());
				/*is.read()*/
				
				
				
			}
			
			os.close();
			is.close();
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
