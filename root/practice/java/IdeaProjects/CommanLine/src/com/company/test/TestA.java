package com.company.test;

import com.company.main.CustomClassLoader;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestA {


    @Test
    public void m(){

        try {

            String file=            this.getClass().getClassLoader().getResource("").getFile();

            List<URL> urlList=new ArrayList<URL>();



            urlList.add(new URL(("file:"+file+"a.jar")));
            CustomClassLoader customClassLoader=new CustomClassLoader(urlList);
            /*customClassLoader.loadClass("javax.xml.ws.Service");*/

            /*URLClassLoader urlClassLoader=URLClassLoader.newInstance(new URL[]{new URL("file:"+file+"a.jar")});*/
            Class<?> cls=customClassLoader.loadClass("javax.xml.ws.Service");

            Object object=cls.newInstance();

            Method method=cls.getMethod("m");

            method.invoke(object);



        } catch (MalformedURLException e) {
            e.printStackTrace();
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
