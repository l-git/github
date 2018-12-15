package com.company.algorithm;

/**
 * Created by Galapagos on 2016/9/27.
 */
public class QuickSort {

    public static void main(String args[]){

        int a[]=new int[]{5,3,1,2,4};

        System.out.println("before sort");

        print(a);


        quickSort(a,0,a.length-1);
        System.out.println("after sort");

        print(a);


    }

    static void print(int a[]){
        for(int i:a){
            System.out.println(i);
        }
    }

    static void swap(int a[],int i,int j){
        int t;
        t=a[i];
        a[i]=a[j];
        a[j]=t;

    }

    static int choosePivot(int i,int j){
        return ((i+j)/2);
    }

    static void quickSort(int a[],int m,int n){
        int i,j,k,key;
        if(m<n){
            k=choosePivot(m,n);
            swap(a,m,k);
            key=a[m];
            i=m+1;
            j=n;
            while(i<=j){
                while((i<=n)&&(a[i]<=key)){
                    i++;
                }
                while((j>m)&&(a[j]>key)){
                    j--;
                }
                if(i<j){
                    swap(a,i,j);
                }




            }

            swap(a,m,j);

            quickSort(a,m,j-1);
            quickSort(a,j+1,n);









        }






    }





}
