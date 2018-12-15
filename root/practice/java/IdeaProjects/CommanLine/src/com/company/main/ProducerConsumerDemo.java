package com.company.main;

/**
 * Created by Galapagos on 2016/9/19.
 */
public class ProducerConsumerDemo {

    public static void main(String args[]){

        Product product=new Product();

        Consumer consumer=new Consumer(product,1);

        Producer producer=new Producer(product,1);

        consumer.start();

        producer.start();



    }


}


class Product{

    private String content;

    private boolean available;

    public synchronized String get(){

        while(available==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available=false;
        notifyAll();
        return this.content;
    }


    public synchronized void set(String content){
        while(available==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        available=true;
        notifyAll();
        this.content=content;


    }


}


class Producer extends Thread{

    private Product product;

    private int number;

    public Producer(Product product,int number){
        this.product=product;
        this.number=number;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){

            product.set("string:"+i);

            System.out.println("Producer#"+number+",product:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}

class Consumer extends Thread{

    private Product product;

    private int number;

    public Consumer(Product product,int number){
        this.product=product;
        this.number=number;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){

            String content=product.get();
            System.out.println("Consumer#"+number+",get "+content);

        }

    }


}
