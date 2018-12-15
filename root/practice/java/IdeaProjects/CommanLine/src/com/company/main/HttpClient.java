package com.company.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class HttpClient {


    public static void main(String args[]){

        try {

            String urlStr = "http://www.toutiao.com";


            Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",8888));
            URL url = new URL(urlStr);

            URLConnection urlConnection=url.openConnection();

            HttpURLConnection httpURLConnection= (HttpURLConnection) urlConnection;





            int responseCode=httpURLConnection.getResponseCode();

            System.out.println(responseCode);


            Map<String,List<String>> headerFields=httpURLConnection.getHeaderFields();


            System.out.println(headerFields);


            InputStream inputStream=httpURLConnection.getInputStream();

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }










        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
