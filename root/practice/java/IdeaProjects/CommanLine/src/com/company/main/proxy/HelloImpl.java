package com.company.main.proxy;

/**
 * Created by Galapagos on 2016/10/28.
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("say hello");
    }
}
