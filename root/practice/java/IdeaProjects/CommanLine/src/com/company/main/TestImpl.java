package com.company.main;

/**
 * Created by Galapagos on 2016/9/11.
 */

interface ITest{
    int frood=42;
}

public class TestImpl implements ITest{

    public static final int frood=2;
    public static void main(String args[]){
        System.out.println(frood);
    }

}
