package cc.fj.se.thread.synchronization;

/**
 * Created by asus on 2015/12/6.
 */
public class ThreadWithoutSynchronization extends Thread{
    private String threadName;
    private Thread thread;

    private PrintDemo printDemo;

    public ThreadWithoutSynchronization(String threadName,PrintDemo printDemo){
        this.threadName=threadName;
        this.printDemo=printDemo;
    }

    @Override
    public void run(){

        printDemo.print();
        System.out.println(threadName+" completely");
    }

    public void start(){
        System.out.println(threadName+" start");
        if(thread==null){
            thread=new Thread(this,threadName);
            thread.start();

        }

    }



}
