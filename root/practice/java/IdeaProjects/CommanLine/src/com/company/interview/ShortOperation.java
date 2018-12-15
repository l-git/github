package com.company.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galapagos on 2016/9/11.
 */
public class ShortOperation {





    private int j=10;
    private int i=getValue();


    int getValue(){
        return j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public static void main(String args[]) {

        /*System.out.println(new ShortOperation().i);
        System.out.println(new ShortOperation().j);*/

        ShortOperation shortOperation=new ShortOperation();
        System.out.println(shortOperation.getI());
        System.out.println(shortOperation.getJ());


        System.out.println(shortOperation.getI());
        System.out.println(shortOperation.getJ());


/*        ShortOperation2 shortOperation2=new ShortOperation2();

        System.out.println(shortOperation2.getStrings());*/



    }
}

class ShortOperation2{

    private List<String> stringList=new ArrayList<String>();

    private List<String> strings=getArray();

    private List<String> getArray(){
        List<String> list=new ArrayList<String>();
        list.add("one");
        return list;

    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}