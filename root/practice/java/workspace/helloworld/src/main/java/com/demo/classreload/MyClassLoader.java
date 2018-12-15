package com.demo.classreload;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyClassLoader extends ClassLoader {


    public MyClassLoader(ClassLoader parent){

        super(parent);

    }


    public Class loadClass(String name) throws ClassNotFoundException {

        if(!"com.demo.classreload.Example".equals(name)){

            return super.loadClass(name);

        }


        String u="file:E:\\github\\root\\tech\\java\\workspace\\helloworld\\target\\classes\\com\\demo\\classreload\\Example.class";

        try {
            URL url= new URL(u);


            URLConnection connection=url.openConnection();


            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

            InputStream inputStream=connection.getInputStream();

            int d=inputStream.read();
            while(d!=-1){

                byteArrayOutputStream.write(d);
                d=inputStream.read();

            }

            inputStream.close();


            byte b[]=byteArrayOutputStream.toByteArray();

            return defineClass(name,b,0,b.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }









}
