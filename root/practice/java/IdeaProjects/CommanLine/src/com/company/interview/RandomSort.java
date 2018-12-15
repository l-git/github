package com.company.interview;

/**
 * Created by Galapagos on 2016/9/11.
 */
public class RandomSort {


    public static void main(String args[]){

        int arrInt[]=new int[50];

        for(int i=0;i<50;i++){

            arrInt[i]= (int) (Math.random()*300);

        }

        for(int i=0;i<50;i++){

            System.out.print(arrInt[i]+" ");

        }


    }

}
