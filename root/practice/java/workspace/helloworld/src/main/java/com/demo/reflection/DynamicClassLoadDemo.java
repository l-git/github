package com.demo.reflection;

public class DynamicClassLoadDemo {

    public static void main(String args[]){


        ClassLoader cl=DynamicClassLoadDemo.class.getClassLoader();

        try {
            Class<?> a=cl.loadClass("com.demo.reflection.A");


            System.out.println(a.getName());

            A aa= (A) a.newInstance();


            aa.m();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
