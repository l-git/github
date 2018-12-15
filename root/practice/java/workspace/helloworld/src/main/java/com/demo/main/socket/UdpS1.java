package com.demo.main.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpS1 {

	
	public static void main(String args[]){
		
		
		
		
		try {
			
			System.out.println("udp server");
			DatagramSocket datagramSocket =new DatagramSocket(12345);
			
			byte receive[]=new byte[1024];
			byte send[]=new byte[1024];
			
			while(true){
			
			DatagramPacket datagramPacket=new DatagramPacket(receive,receive.length);
			
			datagramSocket.receive(datagramPacket);
			
			String s=new String(receive);
			System.out.println(s);
			
			send=("udp server:"+s).getBytes();
			
			
			
			DatagramPacket sendDatagramPacket=new DatagramPacket(send,send.length,datagramPacket.getAddress(),datagramPacket.getPort());
			
			datagramSocket.send(sendDatagramPacket);
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
