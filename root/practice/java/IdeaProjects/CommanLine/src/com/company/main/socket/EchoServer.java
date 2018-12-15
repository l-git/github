package com.company.main.socket;

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


            BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String line;

            while((line=bufferedReader.readLine())!=null){

                System.out.println("server:"+line);
                printWriter.println("response:"+line);

/*                String s=bufferedReader.readLine();

                System.out.println(s);*/


            }
















        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
