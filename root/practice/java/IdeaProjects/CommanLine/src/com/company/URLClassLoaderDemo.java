package com.company;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderDemo {


    @Test
    public void m(){

        try {


            URLClassLoader urlClassLoader=URLClassLoader.newInstance(new URL[]{new URL("file:/E:/code/java/")});

            Class<?> c=urlClassLoader.loadClass("Main");
            System.out.println(c);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
