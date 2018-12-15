package com.company.main.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Galapagos on 2016/10/28.
 */
public class TestProxy {

    public static void main(String args[]){

        Hello hello=new HelloImpl();

        InvocationHandler invocationHandler=new MyInvocation(hello);

        hello= (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),invocationHandler);

        hello.sayHello();


    }
}
