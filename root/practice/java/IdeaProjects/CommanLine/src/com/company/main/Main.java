package com.company.main;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Galapagos on 2016/10/22.
 */
public class Main {

    public static void main(String args[]){

        try {
           Class cls= Main.class.getClassLoader().loadClass("com.company.A");

           Object obj=cls.newInstance();

           Method method=cls.getMethod("m");

            System.out.println("...............................");

           method.invoke(obj);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }




    }


}
