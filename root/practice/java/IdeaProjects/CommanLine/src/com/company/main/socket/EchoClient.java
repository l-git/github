package com.company.main.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {


    public static void main(String args[]){

        try {
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















        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
