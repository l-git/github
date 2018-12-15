package com.company.thread.threadsafe;

/**
 * Created by Galapagos on 2016/10/23.
 */
public class ThreadA extends Thread {

    private Num num;

    public ThreadA(Num num){
        this.num=num;
    }

    @Override
    public void run(){
        num.addI("a");


    }


}
