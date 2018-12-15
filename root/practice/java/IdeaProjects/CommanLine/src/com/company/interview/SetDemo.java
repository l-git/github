package com.company.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Galapagos on 2016/9/3.
 */
public class SetDemo {

    @Override
    public int hashCode(){

        return 1;
    }

    @Override
    public boolean equals(Object o){
        return true;
    }

    public static void main(String args[]){

        Set<SetDemo> setDemos=new HashSet<SetDemo>();
        setDemos.add(new SetDemo());
        setDemos.add(new SetDemo());
        setDemos.add(new SetDemo());

        System.out.println(setDemos.size());

        System.out.println(new SetDemo().hashCode());
    }
}
