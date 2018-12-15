package com.company.main;

import org.apache.log4j.Logger;

/**
 * Created by Galapagos on 2016/10/21.
 */
public class TestLog4j {

    private static Logger logger=Logger.getLogger(TestLog4j.class);

    public static void main(String args[]){
        logger.debug("qq");

        logger.getParent();


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


        String s=new String();
        s.concat("abc");
    }


}
