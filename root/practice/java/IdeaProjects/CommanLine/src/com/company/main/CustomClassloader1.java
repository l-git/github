package com.company.main;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassloader1 extends ClassLoader {



    @Override
    public Class<?> findClass(String className){

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

        InputStream inputStream= this.getClass().getClassLoader().getResourceAsStream(className.replaceAll(".","/")+".class");

        int i=-1;
        try {
            while((i=inputStream.read())!=-1){

                byteArrayOutputStream.write(i);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return defineClass(className,byteArrayOutputStream.toByteArray(),0,byteArrayOutputStream.size());
    }


    @Test
    public void t(){


        CustomClassloader1 customClassloader1=new CustomClassloader1();
        try {
            Class<?> aClass=customClassloader1.loadClass("com.company.A");
            Object o=aClass.newInstance();
            Method  m=aClass.getMethod("m");
            m.invoke(o,null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }









}
