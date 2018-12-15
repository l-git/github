package com.company.thread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * Created by Galapagos on 2016/9/9.
 */
public class ThreadDeadLock {


    public static void main(String args[]){

        Object o1=new Object();
        Object o2=new Object();
        Object o3=new Object();

        Thread t1=new Thread(new SyncThread(o1,o2),"t1");
        Thread t2=new Thread(new SyncThread(o2,o3),"t2");
        Thread t3=new Thread(new SyncThread(o3,o1),"t3");

        t1.start();
        t2.start();
        t3.start();
    }


    static class SyncThread extends Thread{


        private Object o1;
        private Object o2;

        public SyncThread(Object o1,Object o2){

            this.o1=o1;
            this.o2=o2;
        }


        @Override
        public void run(){

            synchronized(o1){

                System.out.println(Thread.currentThread().getName()+" get o1 lock");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o2){
                    System.out.println(Thread.currentThread().getName()+" get o2 from o1");
                }

            }



        }

    }

}
