package com.demo.classreload;


public class Main {

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {



        ClassLoader classLoader=Main.class.getClassLoader();

        MyClassLoader myClassLoader=new MyClassLoader(classLoader);


        Class c1=myClassLoader.loadClass("com.demo.classreload.Example");


        ExampleInterface t1= (ExampleInterface) c1.newInstance();
        ExampleSuper t2= (ExampleSuper) c1.newInstance();


        myClassLoader =new MyClassLoader(myClassLoader);

        c1 = classLoader.loadClass("com.demo.classreload.Example");

        t1= (ExampleInterface) c1.newInstance();

        t2= (ExampleSuper) c1.newInstance();




System.out.println("11");











    }


}
