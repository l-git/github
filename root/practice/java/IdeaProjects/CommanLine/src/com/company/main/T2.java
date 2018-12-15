package com.company.main;

/**
 * Created by Galapagos on 2016/9/11.
 */
public class T2 {
    public static void main(String args[]){

        int n=50;

        int total=0;//总数

        int mod;
        int yu;
        int kong;//空瓶子
        while(true){

            yu=n%3;

            mod=n/3;

            total=total+mod;

            kong=yu+mod;

            n=kong;

            if(kong<3){
                System.out.println("总共喝："+(total+50));
                break;
            }





        }
        f();

        DrinkCount  d=new DrinkCount();
        System.out.println(d.drink(50));

    }

    public static void f(){
        int n = 50;         //初始饮料总数
        int i=0;            //兑换次数
        while(true){
            n -= 3;           //喝3瓶
            n++;            //兑换1瓶
            i++;            //兑换次数+1
            if(n<3)
            {
                System.out.println ("共喝了"+(50+i)+"瓶");
                break;
            }
        }
    }

}

class DrinkCount
{
    public  int drink(int n)
    {
        int count=n;
        if(n>=3)
        {
            n=n/3;
            count=count+drink(n);//递归
        }

        return count;
    }
}

