package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Galapagos on 2016/10/31.
 */
public class HelloSpring {
    public static void main(String args[]){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");

        Hello hello= (Hello) applicationContext.getBean("hello");

        hello.say();


    }
}
