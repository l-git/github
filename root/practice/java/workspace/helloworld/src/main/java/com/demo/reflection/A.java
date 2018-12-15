package com.demo.reflection;

import java.lang.reflect.Array;

public class A {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void m(){
        System.out.println("a:"+id);
    }


    public static void main(String args[]){

        try {
            Class iA=Class.forName("[I");

            int iarr[][]= (int[][]) Array.newInstance(iA,3);

            System.out.println(iarr.length);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
