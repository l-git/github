package com.demo.classloader;


public class DynamicClassLoaderDemo {


    public static void main(String args[]){

        ClassLoader classLoader=DynamicClassLoaderDemo.class.getClassLoader();

        try {
            Class c=classLoader.loadClass("com.demo.classloader.Main");

            System.out.println(c.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
