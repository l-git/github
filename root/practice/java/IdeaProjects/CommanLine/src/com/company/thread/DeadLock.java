package com.company.thread;

/**
 * Created by Galapagos on 2016/9/9.
 */
public class DeadLock {

    private static Object o1=new Object();

    private static Object o2=new Object();

    public static void main(String args[]){


        Thread1 t1=new Thread1();

        Thread2 t2=new Thread2();

        t1.start();

        t2.start();


        System.out.println(Thread.currentThread().getName()+" in main");



    }


    private static class Thread1 extends Thread{


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

                    System.out.println(Thread.currentThread().getName()+" get o2 lock from o1");

                }

            }



        }

    }


    private static class Thread2 extends Thread{

        @Override
        public void run(){

            synchronized(o2){

                System.out.println(Thread.currentThread().getName()+" get o2 lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o1){
                    System.out.println(Thread.currentThread().getName()+" get o1 from o2");
                }

            }


        }

    }


}
