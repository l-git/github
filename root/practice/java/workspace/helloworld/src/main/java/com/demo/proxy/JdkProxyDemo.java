package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Galapagos on 2018/6/9.
 */
public class JdkProxyDemo {



    interface If {
        String f(String s);

        String f1(String s);
    }


    static class IfImpl implements If{

        public String f(String s) {

            System.out.println(s);

            return "f:"+s;
        }


        public String f1(String s) {

            System.out.println(s);

            return "f1:"+s;
        }
    }


    static class Handler implements InvocationHandler{

        private Object proxed;


        public Handler(Object proxed){
            this.proxed=proxed;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("before");
           Object result= method.invoke(this.proxed,args);

            System.out.println("after");

            return result;
        }
    }



    public static void main(String[] args){

        IfImpl ifImpl=new IfImpl();


        InvocationHandler invocationHandler=new Handler(ifImpl);


        If i= (If) Proxy.newProxyInstance(If.class.getClassLoader(),new Class[]{If.class},invocationHandler);


        System.out.println(i.f("hhhhh"));

        System.out.println(i.f1("hhhhh"));





    }














}
