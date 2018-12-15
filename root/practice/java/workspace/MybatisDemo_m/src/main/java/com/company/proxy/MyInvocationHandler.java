package com.company.proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler {


    private static final Logger logger =Logger.getLogger(MyInvocationHandler.class);


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        logger.debug("before");

        if(Object.class.equals(method.getClass())){
            method.invoke(this,args);
        }else{

            logger.debug("=======================================");

        }

        logger.debug("=--------------------------------------------------");
        logger.debug(method.getName());
        logger.debug("=--------------------------------------------------");


        logger.debug("after");

        return "abc";
    }



}
