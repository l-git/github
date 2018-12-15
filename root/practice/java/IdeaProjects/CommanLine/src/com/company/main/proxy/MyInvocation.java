package com.company.main.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Galapagos on 2016/10/28.
 */
public class MyInvocation implements InvocationHandler {

    private Object proxied;

    public MyInvocation(Object proxied){
        this.proxied=proxied;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        proxy=method.invoke(proxied,args);

        System.out.println("after");

        return proxy;
    }
}
