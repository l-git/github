package com.company.thread.threadsafe;

/**
 * Created by Galapagos on 2016/10/23.
 */
public class Num {

    private int i;

    public void addI(String username){

        if("a".equals(username)){
            i=100;
            System.out.println("a set over");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{

            i=200;
            System.out.println("b set over");

        }

        System.out.println(username+" value "+i);

    }


}
