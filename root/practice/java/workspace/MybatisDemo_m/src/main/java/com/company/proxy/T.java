package com.company.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;


public class T {



/*    @Test
    public void m1(){

        Hello hello= (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),new Class[]{Hello.class},new MyInvocationHandler());


        hello.m1("ffff");

    }*/


    @Test
    public void m2(){

        Class<?> proxyClass=Proxy.getProxyClass(Hello.class.getClassLoader(),new Class[]{Hello.class});
       /* Class<?> proxyClass1=Proxy.getProxyClass(Hello.class.getClassLoader(),new Class[]{Hello.class});
        Class<?> proxyClass2=Proxy.getProxyClass(Hello.class.getClassLoader(),new Class[]{Hello.class});
        Class<?> proxyClass3=Proxy.getProxyClass(Hello.class.getClassLoader(),new Class[]{Hello.class});
        Class<?> proxyClass4=Proxy.getProxyClass(Hello.class.getClassLoader(),new Class[]{Hello.class});*/

        Class<?> proxyClassWorld=Proxy.getProxyClass(World.class.getClassLoader(),new Class[]{World.class});



        try {
            Hello hello= (Hello) proxyClass.getConstructor((new Class[]{InvocationHandler.class})).newInstance(new MyInvocationHandler());




            String s=hello.m1("ff");

            System.out.println(s);


            hello.m2();


            World world= (World) proxyClassWorld.getConstructor((new Class[]{InvocationHandler.class})).newInstance(new MyInvocationHandler());
            world.m3();


            while(true);



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
