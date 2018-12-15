package com.demo.main.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpC1 {

	
	public static void main(String args[]){
		
		
		try {
			DatagramSocket datagramSocket=new DatagramSocket();
			
			
			byte receive[]=new byte[1024];
			byte send[]=new byte[1024];
			
			
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
			
			
			String line;
			
			while((line=bufferedReader.readLine())!=null){
				
				send=line.getBytes();
				
				DatagramPacket DatagramPacket=new DatagramPacket(send,send.length,InetAddress.getByName("localhost"),12345);
				datagramSocket.send(DatagramPacket);
				
				DatagramPacket datagramPacket=new DatagramPacket(receive,receive.length);
				datagramSocket.receive(datagramPacket);
				
				System.out.println(new String(receive));
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
