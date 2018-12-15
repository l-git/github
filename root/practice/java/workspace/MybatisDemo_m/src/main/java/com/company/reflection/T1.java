package com.company.reflection;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class T1 {

    private static final Logger logger=Logger.getLogger(T1.class);

    @Test
    public void t1(){


        try {


            List list=ArrayList.class.newInstance();

            logger.debug(list.size());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




        /*try {
            Class stringArrayClass = Class.forName("[Ljava.lang.String;");

            String s[]= (String[]) stringArrayClass.newInstance();

            System.out.println(s);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/


        Class<?> c=Aimpl.class;


        Aimpl aimpl=new Aimpl();

        try {
            Method method=c.getMethod("m1",Object.class);


            Object r=method.invoke(aimpl,"abc");

            System.out.println(r);





        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }



    @Test
    public void t2(){

        boolean b=A.class.isAssignableFrom(Aimpl.class);
        boolean b1=Aimpl.class.isAssignableFrom(A.class);
        logger.debug(b);
        logger.debug(b1);



    }




}
