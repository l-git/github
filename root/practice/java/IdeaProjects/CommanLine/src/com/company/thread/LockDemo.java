package com.company.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Galapagos on 2016/9/11.
 */
public class LockDemo {

    public static void main(String args[]){

        MyService myService=new MyService();
        MyThread myThread1=new MyThread(myService);
        MyThread myThread2=new MyThread(myService);
        MyThread myThread3=new MyThread(myService);
        MyThread myThread4=new MyThread(myService);
        MyThread myThread5=new MyThread(myService);

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();


        System.out.println("main thread");


    }


}

class MyThread extends Thread{

    private MyService myService;
    public MyThread(MyService myService){
        this.myService=myService;
    }

    @Override
    public void run(){

        myService.testMethod();



    }

}

class MyService{

    private Lock lock=new ReentrantLock();
    public void testMethod(){

        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" run "+i);
        }

    }


}
