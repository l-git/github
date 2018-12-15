package com.company.thread.threadsafe;

/**
 * Created by Galapagos on 2016/10/23.
 */
public class TestNum {
    public static void main(String args[]){

        Num num=new Num();

        Thread t1=new ThreadA(num);
        t1.setName("a");

        t1.start();

        Thread t2=new ThreadB(num);
        t2.start();




    }
}
