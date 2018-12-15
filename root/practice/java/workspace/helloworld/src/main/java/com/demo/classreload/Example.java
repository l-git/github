package com.demo.classreload;

public class Example extends ExampleSuper implements ExampleInterface{

    private String s;
    private String s1;



    public void m1(){

        System.out.println(1);

    }

    public static void main(String args[]){

        Example example=new Example();




    }

}
