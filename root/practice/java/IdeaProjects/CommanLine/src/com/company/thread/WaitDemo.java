package com.company.thread;

/**
 * Created by Galapagos on 2016/9/10.
 */
public class WaitDemo {

    public static void main(String args[]){

        final String lock=new String();

        try {

            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    int i=0;
                    synchronized (lock) {
                        for (i = 0; i < 31; i++) {
                            try {
                                System.out.println(i);
                                Thread.sleep(1000);
                                if (i == 3) {
                                    lock.notify();
                                    System.out.println("notify");

                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            t.start();

            System.out.println("start");
            synchronized (lock) {
                lock.wait();
            }
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
