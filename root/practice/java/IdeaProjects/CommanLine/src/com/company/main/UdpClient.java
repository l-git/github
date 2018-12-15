package com.company.main;

import java.io.IOException;
import java.net.*;

/**
 * Created by Galapagos on 2016/5/2.
 */
public class UdpClient {
    public static void main(String args[]){

        try {
            System.out.println("ok start");
            InetAddress inetAddress=InetAddress.getByName("192.168.1.1");

            DatagramSocket datagramSocket=new DatagramSocket(5000);

            byte b[]="ni hao中文".getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(b,0,b.length,inetAddress,5000);
            datagramSocket.send(datagramPacket);
            System.out.println("end");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
